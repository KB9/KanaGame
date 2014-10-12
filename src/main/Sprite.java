package main;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Sprite implements Comparable<Sprite> {
	private int x, y, dx, dy;
	private int levelX, levelY;
	private Image mImage;
	private Rectangle r;

	public Sprite() {
		x = 0;
		y = 0;
	}
	
	public void draw(Graphics2D g){
		r.setLocation(getX(), getY());
		g.drawImage(mImage, getX(), getY(), null);
	}

	public void setImage(String s) {
		mImage = new ImageIcon(getClass().getResource("images/" + s)).getImage();
		r = new Rectangle(getX(), getY(), mImage.getWidth(null), mImage.getHeight(null));
	}
	public void setImage(Image m){
		mImage = m;
		r = new Rectangle(getX(), getY(), mImage.getWidth(null), mImage.getHeight(null));
	}
	
	public boolean Intersects(Sprite s){
		if(this.r.intersects(s.getRect()))
			return true;
		return false;
	}
	
	public Rectangle getRect(){
		return r;
	}
	public Image getImage() {
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
	
	public void setLevelX(int x) {
		levelX = x;
	}
	
	public void setLevelY(int y) {
		levelY = y;
	}
	
	public int getLevelX() {
		return levelX;
	}
	
	public int getLevelY() {
		return levelY;
	}

	public void Move(int dx, int dy) {
		x += dx;
		y += dy;

	}

	@Override
	public int compareTo(Sprite sprite) {
		return this.getY() - sprite.getY();
	}
}
