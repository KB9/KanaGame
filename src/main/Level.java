package main;

import java.awt.Graphics2D;

public class Level {
	
	public static int mLevelTileHeight;
	public static int mLevelTileWidth;
	private int mTileSize;
	
	public static Tile[][] mLevelTiles;
	private LevelSpriteManager mSpriteManager = new LevelSpriteManager();
	private Camera mCamera;

	private int[][] indices;
	private FileHandling fh;
	private TileTypes t = new TileTypes();
	private Buildings b = new Buildings();

	/**
	 * Initialises the level object. Creates and fills an array of tiles which the level
	 * consists of. Adds a default building which is an array of tiles itself.
	 * @param levelTileWidth The number of tiles horizontally in the level
	 * @param levelTileHeight The number of tiles vertically in the level
	 * @param tileSize The width and height of the tile image in pixels
	 */
	public Level(int levelTileWidth, int levelTileHeight, int tileSize) {
		mTileSize = tileSize;
		mLevelTileWidth = levelTileWidth;
		mLevelTileHeight = levelTileHeight;
		
		mLevelTiles = new Tile[mLevelTileWidth][mLevelTileHeight];
		mSpriteManager = new LevelSpriteManager();
		
		fh = new FileHandling();
		indices = fh.readFile();
		
		for(int column = 0; column < mLevelTileWidth; column ++) {
			for(int row = 0; row < mLevelTileHeight; row ++) {
				Tile newTile = new Tile(tileSize);
				newTile.setImage(TileTypes.types[indices[column][row]].getImage());
				newTile.setSolid(false);
				
				setTile(newTile, column, row);
			}
		}
		addBuilding(b);
		
	}
	
	public void addBuilding(Buildings a){
		for(int y = 0; y < a.getBuilding()[0].length; y++){
			for(int x = 0; x < a.getBuilding().length; x++){
				Tile newTile = new Tile(mTileSize);
				newTile.setInfo(a.building[x][y].getImage(), a.building[x][y].getSolid());
				setTile(newTile, y + a.getY(), x + a.getX());		
			}
		}
		
	}
	
	/**
	 * Creates a new camera object which defines the viewport through which the user
	 * looks at the level. Manipulation of the camera coordinates affects the point of the
	 * level the user ends up viewing.
	 * @param viewWidth The width of the viewport (i.e. the screen width)
	 * @param viewHeight The height of the viewport (i.e. the screen height)
	 */
	public void setCameraView(int viewWidth, int viewHeight) {
		mCamera = new Camera(viewWidth, viewHeight, mLevelTileWidth * mTileSize, mLevelTileHeight * mTileSize);
	}

	/**
	 * Draws and updates the positions of the tiles within the camera's view only
	 * @param g2d The graphics class to used for drawing
	 */
	private void clipDrawTiles(Graphics2D g2d) {
		// Defines the bounding box for the clipping boundaries
		int tilesStartColumn = (mCamera.getX() / mTileSize);
		int tilesStartRow = (mCamera.getY() / mTileSize);
		int tilesInViewWidth = (mCamera.getViewWidth() / mTileSize) + 1;
		int tilesInViewHeight = (mCamera.getViewHeight() / mTileSize) + 2;
		
		// Defines which column and row index the loop should end at (i.e. bottom right of box)
		int columnLoopLength = (tilesStartColumn + tilesInViewWidth);
		int rowLoopLength = (tilesStartRow + tilesInViewHeight);
		
		// Loops through all the tiles inside the box and updates and draws them
		for(int column = tilesStartColumn; column < columnLoopLength; column ++) {
			for(int row = tilesStartRow; row < rowLoopLength; row ++) {
				updateTilePosition(column, row);
				Tile tile = getTile(column, row);
				if(tile != null) {
					tile.draw(g2d);
				}
			}
		}
	}
	
	/**
	 * Updates a tile's position on screen based on the camera's position
	 * @param column The column index of the tile
	 * @param row The row index of the tile
	 */
	private void updateTilePosition(int column, int row) {
		Tile tile = getTile(column, row);
		if(tile != null) {
			tile.setX(-mCamera.getX() + (column * mTileSize));
			tile.setY(-mCamera.getY() + (row * mTileSize));
		}
	}
	
	private void clipDrawSprites(Graphics2D g2d) {
		// Defines the bounding box for the clipping boundaries
		int viewLeft = mCamera.getX();
		int viewTop = mCamera.getY();
		int viewRight= mCamera.getX() + mCamera.getViewWidth();
		int viewBottom = mCamera.getY() + mCamera.getViewHeight();
		
		// Loops through each sprite, checks if it's in the viewport and updates/draws it
		for(Sprite sprite : mSpriteManager.getSprites()) {
			int spriteLeft = sprite.getLevelX();
			int spriteTop = sprite.getLevelY();
			int spriteRight = (int)(sprite.getLevelX() + sprite.getRect().getWidth());
			int spriteBottom = (int)(sprite.getLevelY() + sprite.getRect().getHeight());
			if(spriteLeft >= viewLeft || spriteTop >= viewTop || spriteRight <= viewRight || spriteBottom <= viewBottom) {
				updateSpritePosition();
				sprite.draw(g2d);
			}
		}
	}
	
	/**
	 * Updates the sprite's position based on the camera viewport and its position within
	 * the level.
	 */
	private void updateSpritePosition() {
		for(Sprite sprite : mSpriteManager.getSprites()) {
			sprite.setX(-mCamera.getX() + sprite.getLevelX());
			sprite.setY(-mCamera.getY() + sprite.getLevelY());
		}
	}
	
	/**
	 * Draws the tiles and sprites within the screen view in the level. Only works if
	 * a camera view has been specified beforehand.
	 * @param g2d The graphics class used to draw
	 */
	public void drawLevel(Graphics2D g2d) {
		if(mCamera != null) {
			clipDrawTiles(g2d);
			clipDrawSprites(g2d);
		}
		else {
			System.out.println("DEBUG ERROR: Level > Camera view dimensions not specified!");
		}
	}
	
	/**
	 * Sets the position of the camera view in the level.
	 * @param x integer x-coordinate
	 * @param y integer y-coordinate
	 */
	public void setCameraPos(int x, int y) {
		if(mCamera != null) {
			mCamera.setFocus(x, y);
		}
		else {
			System.out.println("DEBUG ERROR: Level > Cannot set camera without view dimensions!");
		}
	}
	
	/**
	 * Pans the camera view according to the Cartesian delta values specified.
	 * @param deltaX The delta to move along the horizontal plane
	 * @param deltaY The delta to move along the vertical plane
	 */
	public void panCamera(int deltaX, int deltaY) {
		if(mCamera != null) {
			mCamera.translate(deltaX, deltaY);
		}
		else {
			System.out.println("DEBUG ERROR: Level > Cannot pan camera without view dimensions!");
		}
	}
	
	/**
	 * Adds a sprite to the level by assigning level coordinates to it and adding it to the
	 * sprite manager. The sprite manager is an ArrayList of Sprite objects, used to keep
	 * track of all the sprites within the level.
	 * @param sprite The sprite to add to the level.
	 */
	public void addSprite(Sprite sprite) {
		sprite.setLevelX(mCamera.getX() + sprite.getX());
		sprite.setLevelY(mCamera.getY() + sprite.getY());
		mSpriteManager.add(sprite);
	}
	
	/**
	 * Sorts the sprites within the ArrayList into y-ascending order, so that sprites drawn
	 * below other sprites are always drawn first irrespective of the order they were added
	 * to the sprite manager. 
	 */
	public void sortSprites() {
		mSpriteManager.sort();
	}
	
	public int getLevelTileWidth(){
		return mLevelTileWidth;
	}
	
	public int getLevelTileHeight(){
		return mLevelTileHeight;
	}
	
	/**
	 * Overwrites the tile object at the specified tile column and row indexes. Checks that
	 * the indexes are valid before overwriting.
	 * @param tile The new tile to overwrite the old.
	 * @param column The column index at which the new tile should be placed.
	 * @param row The row index at which the new tile should be placed.
	 */
	public void setTile(Tile tile, int column, int row) {
		if(column >= 0 && column < mLevelTileWidth && row >= 0 && row < mLevelTileHeight) {
			mLevelTiles[column][row] = tile;
		}
	}
	
	/**
	 * Gets a tile at the specified column and row indexes as long as they are valid indexes.
	 * @param column The column index at which the tile is located.
	 * @param row The row index at which the tile is located.
	 * @return Tile object
	 */
	public Tile getTile(int column, int row) {
		if(column >= 0 && column < mLevelTileWidth && row >= 0 && row < mLevelTileHeight) {
			return mLevelTiles[column][row];
		}
		return null;
	}
}
