package main;

import java.awt.Graphics2D;

public interface SceneDrawable {

	public void draw(Graphics2D g2d);
	public void setX(int x);
	public void setY(int y);
	public int getX();
	public int getY();
}
