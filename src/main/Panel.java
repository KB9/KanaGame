package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;

public class Panel extends JPanel{
	
	private LoopTask mLoop;
	Sprite a,b;
	
	public Panel()
	{
		setFocusable(true);
		setPreferredSize(new Dimension(Frame.getSize()));
		a = new Sprite();
		b = new Sprite();
		a.setImage("images/square.png");
		b.setImage("images/square.png");
		a.setX(10);
		b.setX(800);
		a.setY(10);
		
		
		b.setY(10);
		mLoop = new LoopTask() {

			@Override
			protected void onProcessInput() {
				
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
		
	}

}
