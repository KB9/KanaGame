package main;

import input.InputKey;
import input.InputObject;
import input.InputQueue;
import input.InputXY;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Panel extends JPanel{
	
	private LoopTask mLoop;
	//private KeyEventListener mKeyEventListener;
	private InputQueue mInputQueue;
	private Level mLevel;
	
	public Panel()
	{
		setFocusable(true);
		
		//mKeyEventListener = new KeyEventListener();
		//addKeyListener(mKeyEventListener);
		mInputQueue = new InputQueue();
		addKeyListener(mInputQueue.mKeyEventListener);
		
		mLevel = new Level(80, 100, 16);

		mLoop = new LoopTask() {

			@Override
			protected void onProcessInput() {
				InputObject input;
				while((input = mInputQueue.getNext()) != null) {
					// Work with your key characters
					if(input instanceof InputKey) {
						
					}
					// Work with your xy mouse clicks
					else if(input instanceof InputXY) {
						
					}
				}
			}

			@Override
			protected void onUpdateLogic() {
				mLevel.panCamera(0, 1);
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
		g2d.scale(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/1280.0, Toolkit.getDefaultToolkit().getScreenSize().getHeight()/720.0);
		mLevel.drawLevel(g2d);
	}

}
