package main;

public class Tile extends Sprite {
	
	private int mTileSize;

	public Tile(int tileSize) {
		mTileSize = tileSize;
	}
	
	public int getTileSize() {
		return mTileSize;
	}
}
