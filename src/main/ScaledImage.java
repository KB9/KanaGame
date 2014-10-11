package main;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class ScaledImage {
	
	private Image mImage;
	private Dimension mImageDimension;

	public ScaledImage(String filePath) {
		mImage = new ImageIcon(getClass().getResource("images/" + filePath)).getImage();
		Dimension unscaledDimension = new Dimension(mImage.getWidth(null), mImage.getHeight(null));
		mImageDimension = ScaleUtil.scale(unscaledDimension);
	}
	
	public Image getImage() {
		return mImage;
	}
	
	public Dimension getSize() {
		return mImageDimension;
	}
}
