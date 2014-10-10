package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

public class KeyEventListener implements KeyListener {
	
	private LinkedList<KeyEvent> mKeyEventList;
	
	public KeyEventListener() {
		mKeyEventList = new LinkedList<KeyEvent>();
	}

	@Override
	public void keyPressed(KeyEvent event) {
	}

	@Override
	public void keyReleased(KeyEvent event) {
	}

	@Override
	public void keyTyped(KeyEvent event) {
		mKeyEventList.add(event);
	}
	
	private char getKeyCharacter(KeyEvent event) {
		return event.getKeyChar();
	}
	
	public void processInput() {
		for(int i = 0; i < mKeyEventList.size(); i ++) {
			KeyEvent event = mKeyEventList.removeFirst();
			// SpriteManager class handles input
		}
	}
}
