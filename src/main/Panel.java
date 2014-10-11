package main;

import input.InputKey;
import input.InputQueue;
import input.InputXY;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Panel extends JPanel{
	
	private InputQueue mInputQueue;
	private Level mLevel;
	
	public Panel()
	{
		setFocusable(true);
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width,
				Toolkit.getDefaultToolkit().getScreenSize().height);
		setBackground(Color.BLACK);
		
		mInputQueue = new InputQueue();
		addKeyListener(mInputQueue.getKeyListener());
		
		mLevel = new Level(150, 100, 16);
		mLevel.setCameraView(getWidth(), getHeight());

		new LoopTask() {

			@Override
			protected void onProcessInput() {
				
				InputKey key;
				while((key = mInputQueue.getNextKey()) != null) {
					switch(key.getArrowKey()) {
					case 0:
						mLevel.panCamera(0, -4);
						break;
					case 1:
						mLevel.panCamera(-4, 0);
						break;
					case 2:
						mLevel.panCamera(0, 4);
						break;
					case 3:
						mLevel.panCamera(4, 0);
						break;
					}
				}
				
				InputXY click;
				while((click = mInputQueue.getNextXY()) != null) {
					// Process click here
				}
			}

			@Override
			protected void onUpdateLogic() {
			}

			@Override
			protected void onDraw() {
				repaint();
			}
		};
	}
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		mLevel.drawLevel(g2d);
	}

}
