package main;

import java.util.ArrayList;
import java.util.Collections;

public class LevelSpriteManager {

	private ArrayList<Sprite> mSpriteList;
	
	public LevelSpriteManager() {
		mSpriteList = new ArrayList<Sprite>();
	}
	
	public void add(Sprite sprite) {
		mSpriteList.add(sprite);
	}
	
	public ArrayList<Sprite> getSprites() {
		return mSpriteList;
	}
	
	public void sort() {
		Collections.sort(mSpriteList);
	}
	
	public void remove(Sprite sprite) {
		mSpriteList.remove(sprite);
	}
}
