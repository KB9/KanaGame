package main;

public class Level {
	
	private final int TILE_SIZE = 64;
	
	private Tile[][] mLevelTiles;

	public Level(int levelSize) {
		mLevelTiles = new Tile[levelSize][levelSize];
		
		for(int column = 0; column < levelSize; column ++) {
			for(int row = 0; row < levelSize; row ++) {
				mLevelTiles[column][row] = new Tile(TILE_SIZE);
			}
		}
	}
	
	public Tile getTile(int column, int row) {
		return mLevelTiles[column][row];
	}
}
