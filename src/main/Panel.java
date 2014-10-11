package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Panel extends JPanel{
	
	private LoopTask mLoop;
	private Level mLevel;
	private KeyEventListener mKeyEventListener;
	
	public Panel()
	{
		setFocusable(true);
		setPreferredSize(new Dimension(Frame.getSize()));
		
		mLevel = new Level(30, 16);
		
		mKeyEventListener = new KeyEventListener();
		addKeyListener(mKeyEventListener);
		
		mLoop = new LoopTask() {

			@Override
			protected void onProcessInput() {
				mKeyEventListener.processInput();
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
		mLevel.draw(g2d);
	}

}
