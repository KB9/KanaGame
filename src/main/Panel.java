package main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JPanel;

public class Panel extends JPanel{
	
	private LoopTask mLoop;
	private KeyEventListener mKeyEventListener;
	private Level mLevel;
	
	public Panel()
	{
		setFocusable(true);
		
		mKeyEventListener = new KeyEventListener();
		addKeyListener(mKeyEventListener);
		
		mLevel = new Level(45, 100, 16);

		mLoop = new LoopTask() {

			@Override
			protected void onProcessInput() {
				mKeyEventListener.processInput();
			}

			@Override
			protected void onUpdateLogic() {
				Random random = new Random();
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
