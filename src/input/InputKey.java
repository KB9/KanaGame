package input;

import java.awt.event.KeyEvent;

public class InputKey {
	
	private KeyEvent mEvent;
	private boolean mIsPressed;

	public InputKey(KeyEvent event) {
		mEvent = event;
		mIsPressed = true;
	}
	
	public char getCharKey() {
		if(mEvent.getKeyChar() != KeyEvent.CHAR_UNDEFINED) {
			return mEvent.getKeyChar();
		}
		return ' ';
	}
	
	public int getArrowKey() {
		switch(mEvent.getKeyCode()) {
		case KeyEvent.VK_UP:
			return 0;
		case KeyEvent.VK_LEFT:
			return 1;
		case KeyEvent.VK_DOWN:
			return 2;
		case KeyEvent.VK_RIGHT:
			return 3;
		default:
			return -1;
		}
	}
	
	public void setPressed(boolean isPressed) {
		mIsPressed = isPressed;
	}
	
	public boolean getPressed() {
		return mIsPressed;
	}
	
	private int getKeyCode() {
		return mEvent.getKeyCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(getKeyCode() == ((InputKey)obj).getKeyCode()) {
			return true;
		}
		return false;
	}
}
