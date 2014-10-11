package main;

import java.awt.Graphics2D;
import java.awt.Toolkit;

public class Level {
	
	public static int mLevelTileHeight;
	public static int mLevelTileWidth;
	private int mTileSize;
	
	public static Tile[][] mLevelTiles;
	private LevelSpriteManager mSpriteManager = new LevelSpriteManager();
	private Camera mCamera;
	private Tile[] types = new Tile[10];
	private int[][] indices;
	private FileHandling fh;

	public Level(int levelTileWidth, int levelTileHeight, int tileSize, int viewWidth, int viewHeight) {
		mTileSize = tileSize;
		mLevelTileWidth = levelTileWidth;
		mLevelTileHeight = levelTileHeight;
		
		mLevelTiles = new Tile[mLevelTileWidth][mLevelTileHeight];
		mSpriteManager = new LevelSpriteManager();
		mCamera = new Camera(viewWidth, viewHeight, mLevelTileWidth * tileSize, mLevelTileHeight * tileSize);
		
		fh = new FileHandling();
		indices = fh.readFile();
		types[0] = new Tile();
		types[0].setInfo("grass.png", false);
		//types[1].setInfo("wall.png", true);
		//types[2].setInfo("floor.png", false);
		
		for(int column = 0; column < mLevelTileWidth; column ++) {
			for(int row = 0; row < mLevelTileHeight; row ++) {
				Tile newTile = new Tile(tileSize);
				newTile.setX(-mCamera.getX() + (column * tileSize));
				newTile.setY(-mCamera.getY() + (row * tileSize));
				newTile.setImage(types[indices[column][row]].getImage());
				newTile.setSolid(false);
				mLevelTiles[column][row] = newTile;
			}
		}
	}
	
	public void clipDrawTiles(Graphics2D g2d) {
		int tilesStartColumn = (mCamera.getX() / mTileSize) + 1;
		int tilesStartRow = (mCamera.getY() / mTileSize) + 1;
		int tilesInViewWidth = (mCamera.getViewWidth() / mTileSize) - 1;
		int tilesInViewHeight = (mCamera.getViewHeight() / mTileSize) - 1;
		
		int columnLoopLength = (tilesStartColumn + tilesInViewWidth);
		int rowLoopLength = (tilesStartRow + tilesInViewHeight);
		
		for(int column = tilesStartColumn; column < columnLoopLength; column ++) {
			for(int row = tilesStartRow; row < rowLoopLength; row ++) {
				updateTilePosition(column, row);
				mLevelTiles[column][row].draw(g2d);
			}
		}
	}
	
	public void updateTilePosition(int column, int row) {
		Tile tile = mLevelTiles[column][row];
		tile.setX(-mCamera.getX() + (column * mTileSize));
		tile.setY(-mCamera.getY() + (row * mTileSize));
	}
	
	public void drawLevel(Graphics2D g2d) {
		clipDrawTiles(g2d);
		mSpriteManager.drawSprites(g2d);
	}
	
	public void setCamera(int x, int y) {
		mCamera.setFocus(x, y);
	}
	
	public void panCamera(int deltaX, int deltaY) {
		mCamera.translate(deltaX, deltaY);
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
	
	public Tile getTile(int column, int row) {
		return mLevelTiles[column][row];
	}
}
