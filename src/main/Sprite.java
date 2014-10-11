package main;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Sprite {
	private int x, y, dx, dy;
	private ScaledImage mImage;
	private Rectangle r;

	public Sprite() {
		x = 0;
		y = 0;
	}
	
	public void draw(Graphics2D g){
		r.setLocation(getX(), getY());
		mImage.drawImage(g, getX(), getY());
	}

	public void setImage(String s) {
		mImage = new ScaledImage(s);
		r = new Rectangle(getX(), getY(), mImage.getSize().width, mImage.getSize().height);
	}
	
	public boolean Intersects(Sprite s){
		if(this.r.intersects(s.getRect()))
			return true;
		return false;
	}
	
	public Rectangle getRect(){
		return r;
	}
	public ScaledImage getImage() {
		return mImage;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void Move(int dx, int dy) {
		x += dx;
		y += dy;

	}
}
