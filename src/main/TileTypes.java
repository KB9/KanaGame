package main;

public class TileTypes extends Tile{
	
	public static Tile[] types = new Tile[10];
	
	public TileTypes(){
		for(int i = 0; i < types.length; i++){
			types[i] = new Tile();
		}
		types[0].setInfo("grass.png", false);
		types[1].setInfo("bricks.png", true);
		types[2].setInfo("floor_tile.png", false);
	}
}
