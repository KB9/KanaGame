package main;

import java.awt.Graphics2D;

public class Level implements SceneDrawable {
	
	private int mX, mY;
	private Tile[][] mLevelTiles;
	private int mLevelTileHeight;
	private int mLevelTileWidth;
	private int mTileSize;

	public Level(int levelSizeA, int levelSizeB, int tileSize) {
		mTileSize = tileSize;
		mLevelTileHeight = levelSizeA;
		mLevelTileWidth = levelSizeB;
		
		mLevelTiles = new Tile[mLevelTileWidth][mLevelTileHeight];
		
		for(int column = 0; column < mLevelTileWidth; column ++) {
			for(int row = 0; row < mLevelTileHeight; row ++) {
				Tile newTile = new Tile(tileSize);
				newTile.setX(mX + (column * tileSize));
				newTile.setY(mY + (row * tileSize));
				newTile.setImage("square.png");
				mLevelTiles[column][row] = newTile;
			}
		}
	}
	
	public void draw(Graphics2D g2d) {
		for(int column = 0; column < mLevelTileWidth; column ++) {
			for(int row = 0; row < mLevelTileHeight; row ++) {
				Tile currentTile = mLevelTiles[column][row];
				currentTile.setX(mX + (column * mTileSize));
				currentTile.setY(mY + (row * mTileSize));
				currentTile.draw(g2d);
			}
		}
	}
	
	public void setX(int x) {
		mX = x;
	}
	
	public void setY(int y) {
		mY = y;
	}
	
	public int getX() {
		return mX;
	}
	
	public int getY() {
		return mY;
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
