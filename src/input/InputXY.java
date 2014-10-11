package input;

public class InputXY extends InputObject {

	private int mX, mY;
	
	public InputXY(int x, int y) {
		mX = x;
		mY = y;
	}
	
	public int getX() {
		return mX;
	}
	
	public int getY() {
		return mY;
	}
}
