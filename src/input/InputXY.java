package input;

import java.awt.event.MouseEvent;

public class InputXY {

	private int mX, mY;
	
	public InputXY(MouseEvent event) {
		mX = event.getX();
		mY = event.getY();
	}
	
	public int getX() {
		return mX;
	}
	
	public int getY() {
		return mY;
	}
}
