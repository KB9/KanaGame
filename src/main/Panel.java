package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Panel extends JPanel{
	
	private LoopTask mLoop;
	private Level mLevel;
	private KeyEventListener mKeyEventListener;
	Sprite a,b;
	
	public Panel()
	{
		setFocusable(true);
		setPreferredSize(new Dimension(Frame.getSize()));
		a = new Sprite();
		b = new Sprite();
		a.setImage("square.png");
		b.setImage("square.png");
		a.setX(10);
		b.setX(800);
		a.setY(10);
		
		mLevel = new Level(64, 16);
		
		mKeyEventListener = new KeyEventListener();
		addKeyListener(mKeyEventListener);
		
		b.setY(10);
		mLoop = new LoopTask() {

			@Override
			protected void onProcessInput() {
				mKeyEventListener.processInput();
			}

			@Override
			protected void onUpdateLogic() {
				b.Move(-1, 0);
				if(b.Intersects(a))
					System.out.println("INTERSECTS");
				
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
		a.draw(g2d);
		b.draw(g2d);
		mLevel.draw(g2d);
	}

}
