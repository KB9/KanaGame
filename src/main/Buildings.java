package main;

public class Buildings extends Tile{
	int x, y;
	TileTypes t = new TileTypes();
	int[][] tileMap = { 
			{1,1,1,1,1,1,1,1},
			{1,2,2,2,2,2,2,1},
			{1,2,2,2,2,2,2,1},
			{1,2,2,2,2,2,2,1},
			{1,2,2,2,2,2,2,1},
			{1,2,2,2,2,2,2,1},
			{1,2,2,2,2,2,2,1},
			{1,1,1,1,1,1,1,1}	
	};
	public Tile[][] building = new Tile[8][8];
	
	public Buildings(){
		x = 30;
		y = 30;
		
		for(int b = 0; b < building.length; b++){
			for(int a = 0; a < building.length; a++){
				building[a][b] = new Tile();
				building[a][b].setImage(TileTypes.types[tileMap[a][b]].getImage());
				building[a][b].setSolid(TileTypes.types[tileMap[a][b]].getSolid());
			}
		}
	}
	
	public Tile[][] getBuilding(){
		return building;
		
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}

}
