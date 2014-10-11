package main;

import java.awt.Image;
import java.awt.Toolkit;

public class Tile extends Sprite {
	
	private boolean solid;
	private int mTileSize;
	
	public Tile(){
		
	}

	public Tile(int tileSize) {
		mTileSize = tileSize;
	}
	
	public int getTileSize() {
		return mTileSize;
	}
	
	public boolean getSolid(){
		return solid;
	}
	
	public void setInfo(String s, boolean x){
		setImage(s);
		this.solid = x;
	}
	
	public void setInfo(Image m, boolean x){
		setImage(m);
		this.solid = x;
	}
}
