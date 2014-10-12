package main;

import input.InputKey;
import input.InputQueue;
import input.InputXY;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Panel extends JPanel{
	
	private InputQueue mInputQueue;
	public static Level mLevel;
	private Font mTimeFont = new Font("Calibri", Font.PLAIN, 32);
	private Image mLogoImage = new ImageIcon(getClass().getResource("images/kanagame_logo.png")).getImage();
	private ButtonPanel bpanel = new ButtonPanel();
	
	public Panel()
	{
		setFocusable(true);
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width,
				Toolkit.getDefaultToolkit().getScreenSize().height- 90);
		setBackground(Color.BLACK);
		JButton b = new JButton("This is a button");
		b.setLocation(getWidth() - 50, getHeight()- 200);
		b.setVisible(true);
		add(b);
		
		mInputQueue = new InputQueue();
		addKeyListener(mInputQueue.getKeyListener());
		addMouseListener(mInputQueue.getMouseListener());
		
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

					// This line must be kept so that mouse events don't linger...
					xyIterator.remove();
					requestFocus();
				}
			}

			@Override
			protected void onUpdateLogic() {
				mLevel.sortSprites();
				ButtonPanel.updates();
				
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
		
		g2d.drawImage(mLogoImage, this.getWidth() - mLogoImage.getWidth(null), 0, null);
		
		g2d.setColor(Color.WHITE);
		g2d.setFont(mTimeFont);
		
		String timeString = GameClock.getHours() + ":" + GameClock.getMinutes() + ":" + GameClock.getSeconds();
		g2d.drawString("TIME: " + timeString, 10, 25);
		g2d.scale(getWidth()/960, getHeight()/540);
	}
}
