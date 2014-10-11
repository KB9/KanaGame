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
	
	private LoopTask mLoop;
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
		
		mLevel = new Level(200, 200, 16, getWidth(), getHeight());

		mLoop = new LoopTask() {

			@Override
			protected void onProcessInput() {
				
				InputKey key;
				while((key = mInputQueue.getNextKey()) != null) {
					switch(key.getCharKey()) {
					case 'w':
						mLevel.panCamera(0, -4);
						break;
					case 'a':
						mLevel.panCamera(-4, 0);
						break;
					case 's':
						mLevel.panCamera(0, 4);
						break;
					case 'd':
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
		//g2d.scale(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/1280.0, Toolkit.getDefaultToolkit().getScreenSize().getHeight()/720.0);
		mLevel.drawLevel(g2d);
	}

}
