package main;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import util.ScaleUtil;

public class ScaledImage {
	
	private Image mImage;
	private Dimension mImageDimension;

	public ScaledImage(String filePath) {
		mImage = new ImageIcon(getClass().getResource("images/" + filePath)).getImage();
		Dimension unscaledDimension = new Dimension(mImage.getWidth(null), mImage.getHeight(null));
		mImageDimension = ScaleUtil.scale(unscaledDimension);
	}
	
	public void drawImage(Graphics2D g2d, int x, int y) {
		g2d.drawImage(mImage, x, y, null);
	}
	
	public Dimension getSize() {
		return mImageDimension;
	}
}
