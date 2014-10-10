package main;

import javax.swing.JFrame;

public class Frame {
	public static void main(String[] args){
		JFrame f = new JFrame("GAME!!!");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//f.add(new Panel);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
	}

}
