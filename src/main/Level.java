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
				mLevelTiles[column][row] = new Tile(TILE_SIZE);
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
