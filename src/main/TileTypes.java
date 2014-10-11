package main;

public class TileTypes extends Tile{
	
	public static Tile[] types = new Tile[13];
	
	public TileTypes(){
		for(int i = 0; i < types.length; i++){
			types[i] = new Tile();
		}
		types[0].setInfo("grass.png", false);
		types[1].setInfo("bush.png", false);
		types[2].setInfo("red_flower.png", false);
		types[3].setInfo("yellow_flower.png", false);
		types[4].setInfo("red_carpet.png", false);
		types[5].setInfo("blue_carpet.png", false);
		types[6].setInfo("purple_carpet.png", false);
		types[7].setInfo("green_carpet.png", false);
		types[8].setInfo("bricks.png", true);
		types[9].setInfo("floor_tile.png", false);
		types[10].setInfo("corner_floor_tile.png", false);
		types[11].setInfo("horizontal_window.png", false);
		types[12].setInfo("vertical_window.png", false);
	}
}
