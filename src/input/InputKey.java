package input;

import java.awt.event.KeyEvent;

public class InputKey extends InputObject {
	
	private char mKeyChar;

	public InputKey(KeyEvent event) {
		if(event.getKeyChar() != KeyEvent.CHAR_UNDEFINED) {
			mKeyChar = event.getKeyChar();
		}
	}
	
	public char getInputData() {
		return mKeyChar;
	}
}
