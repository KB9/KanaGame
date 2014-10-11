package main;

import input.InputKey;
import input.InputQueue;
import input.InputXY;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.Iterator;

import javax.swing.JPanel;

public class Panel extends JPanel{
	
	private InputQueue mInputQueue;
	private Level mLevel;
	private Font timeFont = new Font("Calibri", Font.PLAIN, 32);
	
	public Panel()
	{
		setFocusable(true);
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width,
				Toolkit.getDefaultToolkit().getScreenSize().height);
		setBackground(Color.BLACK);
		
		mInputQueue = new InputQueue();
		addKeyListener(mInputQueue.getKeyListener());
		
		mLevel = new Level(100, 80, 16);
		mLevel.setCameraView(getWidth(), getHeight());

		new LoopTask() {

			@Override
			protected void onProcessInput() {
				
				Iterator<InputKey> keyIterator = mInputQueue.getPressedKeys().iterator();
				while(keyIterator.hasNext()) {
					InputKey key = keyIterator.next();
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
				
				Iterator<InputXY> xyIterator = mInputQueue.getXYs().iterator();
				while(xyIterator.hasNext()) {
					InputXY xy = xyIterator.next();
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
		
		g2d.setFont(timeFont);
		String timeString = GameClock.getHours() + ":" + GameClock.getMinutes() + ":" + GameClock.getSeconds();
		g2d.drawString("TIME: " + timeString, 10, 25);
	}

}
