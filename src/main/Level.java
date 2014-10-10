package main;

import java.awt.Graphics2D;

public class Level {
	
	private Tile[][] mLevelTiles;
	private int mLevelSize;
	private int mTileSize;

	public Level(int levelSize, int tileSize) {
		mLevelSize = levelSize;
		mLevelTiles = new Tile[mLevelSize][mLevelSize];
		
		for(int column = 0; column < mLevelSize; column ++) {
			for(int row = 0; row < mLevelSize; row ++) {
				Tile newTile = new Tile(tileSize);
				newTile.setX(column * tileSize);
				newTile.setY(row * tileSize);
				newTile.setImage("square.png");
				mLevelTiles[column][row] = newTile;
			}
		}
	}
	
	public void draw(Graphics2D g2d) {
		for(int column = 0; column < mLevelSize; column ++) {
			for(int row = 0; row < mLevelSize; row ++) {
				Tile currentTile = mLevelTiles[column][row];//t
				currentTile.draw(g2d);
			}
		}
	}
	
	public Tile getTile(int column, int row) {
		return mLevelTiles[column][row];
	}
}
