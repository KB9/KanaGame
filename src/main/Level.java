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
<<<<<<< HEAD
				//newTile.setX(-mCamera.getX() + (column * tileSize));
				//newTile.setY(-mCamera.getY() + (row * tileSize));
				newTile.setImage(TileTypes.types[indices[column][row]].getImage());
=======
				newTile.setImage(types[indices[column][row]].getImage());
>>>>>>> origin/master
				newTile.setSolid(false);
				
				setTile(newTile, column, row);
			}
		}
		addBuilding(b);
		
	}
	
	public void addBuilding(Buildings a){
		for(int y = 0; y < a.getBuilding().length; y++){
			for(int x = 0; x < a.getBuilding().length; x++){
				Tile newTile = new Tile(mTileSize);
				newTile.setInfo(a.building[x][y].getImage(), a.building[x][y].getSolid());
				setTile(newTile, x + a.getX(), y + a.getY());		
			}
		}
		
	}
	
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
	
	/**
	 * Draws the tiles and sprites within the screen view in the level. Only works if
	 * a camera view has been specified beforehand.
	 * @param g2d The graphics class used to draw
	 */
	public void drawLevel(Graphics2D g2d) {
		if(mCamera != null) {
			clipDrawTiles(g2d);
			mSpriteManager.drawSprites(g2d);
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
	
	public void addSprite(Sprite sprite) {
		mSpriteManager.add(sprite);
	}
	
	public int getLevelTileWidth(){
		return mLevelTileWidth;
	}
	
	public int getLevelTileHeight(){
		return mLevelTileHeight;
	}
	
	public void setTile(Tile tile, int column, int row) {
		if(column >= 0 && column < mLevelTileWidth && row >= 0 && row < mLevelTileHeight) {
			mLevelTiles[column][row] = tile;
		}
	}
	
	public Tile getTile(int column, int row) {
		if(column >= 0 && column < mLevelTileWidth && row >= 0 && row < mLevelTileHeight) {
			return mLevelTiles[column][row];
		}
		return null;
	}
}
