package main;

import java.awt.Graphics2D;

public class Level {
	
	private final int TILE_SIZE = 64;
	
	private Tile[][] mLevelTiles;
	private int mLevelSize;

	public Level(int levelSize) {
		mLevelSize = levelSize;
		mLevelTiles = new Tile[mLevelSize][mLevelSize];
		
		for(int column = 0; column < mLevelSize; column ++) {
			for(int row = 0; row < mLevelSize; row ++) {
				Tile newTile = new Tile(TILE_SIZE);
				newTile.setX(column * TILE_SIZE);
				newTile.setY(row * TILE_SIZE);
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
