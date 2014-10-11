package main;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class SpriteManager {

	private ArrayList<SceneDrawable> mDrawables;
	
	public SpriteManager() {
		mDrawables = new ArrayList<SceneDrawable>();
	}
	
	public void add(SceneDrawable drawable) {
		mDrawables.add(drawable);
	}
	
	public void drawAll(Graphics2D g2d) {
		for(int i = 0; i < mDrawables.size(); i ++) {
			mDrawables.get(i).draw(g2d);
		}
	}
	
	public void translateCamera(int dx, int dy) {
		for(int i = 0; i < mDrawables.size(); i ++) {
			int x = mDrawables.get(i).getX();
			int y = mDrawables.get(i).getY();
			mDrawables.get(i).setX(x + dx);
			mDrawables.get(i).setY(y + dy);
		}
	}
}
