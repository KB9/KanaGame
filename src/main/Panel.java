package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;

public class Panel extends JPanel{
	
	private LoopTask mLoop;
	int x = 1;
	public Panel()
	{
		setFocusable(true);
		setPreferredSize(new Dimension(Frame.getSize()));
		
		mLoop = new LoopTask(3000, 40000, 20000, TimeUnit.MILLISECONDS, true) {

			@Override
			protected void onProcessInput() {
				
			}

			@Override
			protected void onUpdateLogic() {
				x+=1;
				System.out.println(x);
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
		//image = new BufferedImage(, arg1, arg2)
		g2d.fillRect(x, 5, 123,512);
		
	}

}
