package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Frame {
	
	static JFrame f;
	
	public static void main(String[] args){
		f = new JFrame("GAME!!!");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new Panel());
		f.pack();
		f.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
	
	public static Dimension getSize(){
		
		return new Dimension(f.getWidth(), f.getHeight());
		
	}
	
}

