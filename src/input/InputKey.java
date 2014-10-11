package input;

import java.awt.event.KeyEvent;

public class InputKey {
	
	private KeyEvent mEvent;

	public InputKey(KeyEvent event) {
		mEvent = event;
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
}
