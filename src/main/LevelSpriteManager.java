package main;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class LevelSpriteManager {

	private ArrayList<Sprite> mSpriteList;
	
	public LevelSpriteManager() {
		mSpriteList = new ArrayList<Sprite>();
	}
	
	public void add(Sprite sprite) {
		mSpriteList.add(sprite);
	}
	
	public void remove(Sprite sprite) {
		mSpriteList.remove(sprite);
	}
	
	public void drawSprites(Graphics2D g2d) {
		for(int i = 0; i < mSpriteList.size(); i ++) {
			Sprite sprite = mSpriteList.get(i);
			int x = sprite.getX();
			int y = sprite.getY();
			g2d.drawImage(sprite.getImage(), x, y, null);
		}
	}
}
