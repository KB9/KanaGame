package main;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;

public class Frame {
	public static void main(String[] args){
		JFrame f = new JFrame("GAME!!!");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//f.add(new Panel);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
        GraphicsDevice d = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        if (d.isFullScreenSupported()) {
             d.setFullScreenWindow(f);
        }
	}
}
