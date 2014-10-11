package main;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Panel extends JPanel{
	
	private LoopTask mLoop;
	private KeyEventListener mKeyEventListener;
	private SpriteManager mSpriteManager;
	
	public Panel()
	{
		setFocusable(true);
		
		mKeyEventListener = new KeyEventListener();
		addKeyListener(mKeyEventListener);
		
		mSpriteManager = new SpriteManager();
		mSpriteManager.add(new Level(30, 16));

		mLoop = new LoopTask() {

			@Override
			protected void onProcessInput() {
				mKeyEventListener.processInput();
			}

			@Override
			protected void onUpdateLogic() {
				mSpriteManager.translateCamera(1, 1);
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
		mSpriteManager.drawAll(g2d);
	}

}
