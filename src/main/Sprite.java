package main;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class Sprite {
	private int x, y, dx, dy;
	//private Image img;
	private ScaledImage mImage;
	private Rectangle r;

	public Sprite() {
		x = 0;
		y = 0;
	}
	
	public void draw(Graphics2D g){
		r.setLocation(getX(), getY());
		g.drawImage(mImage.getImage(), getX(), getY(), null);
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
