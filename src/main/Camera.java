package main;

public class Camera {
	
	private int mX, mY;
	private int mViewWidth, mViewHeight;
	private int mBoundsWidth, mBoundsHeight;

	public Camera(int viewWidth, int viewHeight, int boundsWidth, int boundsHeight) {
		mX = 0;
		mY = 0;
		mViewWidth = viewWidth;
		mViewHeight = viewHeight;
		mBoundsWidth = boundsWidth;
		mBoundsHeight = boundsHeight;
		System.out.println("Camera Settings:" + mViewWidth + "," + mViewHeight + " - " + mBoundsWidth + "," + mBoundsHeight);
	}
	
	public void setFocus(int x, int y) {
		int left = x;
		int top = y;
		int right = x + mViewWidth;
		int bottom = y + mViewHeight;
		
		if(left >= 0 && right <= mBoundsWidth) {
			mX = x;
		}
		if(top >= 0 && bottom <= mBoundsHeight) {
			mY = y;
		}
	}
	
	public void translate(int deltaX, int deltaY) {
		int left = mX + deltaX;
		int top = mY + deltaY;
		int right = mX + mViewWidth + deltaX;
		int bottom = mY + mViewHeight + deltaX;
		
		if(left >= 0 && right <= mBoundsWidth) {
			mX += deltaX;
		}
		if(top >= 0 && bottom <= mBoundsHeight) {
			mY += deltaY;
		}
	}
	
	public int getX() {
		return mX;
	}
	
	public int getY() {
		return mY;
	}
	
	public int getViewWidth() {
		return mViewWidth;
	}
	
	public int getViewHeight() {
		return mViewHeight;
	}
}
