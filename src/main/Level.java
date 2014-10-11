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

	public Level(int levelTileWidth, int levelTileHeight, int tileSize) {
		mTileSize = tileSize;
		mLevelTileWidth = levelTileWidth;
		mLevelTileHeight = levelTileHeight;
		
		mLevelTiles = new Tile[mLevelTileWidth][mLevelTileHeight];
		mSpriteManager = new LevelSpriteManager();
		mCamera = new Camera((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()), (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()), mLevelTileWidth * tileSize, mLevelTileHeight * tileSize);
		
		indices = fh.readFile();
		
		types[0].setInfo("grass.png", false);
		//types[1].setInfo("wall.png", true);
		//types[2].setInfo("floor.png", false);
		
		for(int column = 0; column < mLevelTileWidth; column ++) {
			for(int row = 0; row < mLevelTileHeight; row ++) {
				Tile newTile = new Tile(tileSize);
				newTile.setX(-mCamera.getX() + (column * tileSize));
				newTile.setY(-mCamera.getY() + (row * tileSize));
				newTile.setInfo(types[indices[column][row]].getImage(), types[indices[column][row]].getSolid());
				newTile.setImage("square.png");
				mLevelTiles[column][row] = newTile;
			}
		}
	}
	
	public void drawLevel(Graphics2D g2d) {
		for(int column = 0; column < mLevelTileWidth; column ++) {
			for(int row = 0; row < mLevelTileHeight; row ++) {
				Tile tile = mLevelTiles[column][row];
				tile.setX(-mCamera.getX() + (column * mTileSize));
				tile.setY(-mCamera.getY() + (row * mTileSize));
				tile.draw(g2d);
			}
		}
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
