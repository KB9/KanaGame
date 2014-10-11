package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

public class InputQueue {

	private static LinkedList<InputXY> mClickQueue;
	private static LinkedList<InputKey> mKeyQueue;
	
	private KeyEventListener mKeyEventListener;
	
	public InputQueue() {
		mClickQueue = new LinkedList<InputXY>();
		mKeyQueue = new LinkedList<InputKey>();
		
		mKeyEventListener = new KeyEventListener();
	}
	
	public void addXY(InputXY input) {
		mClickQueue.add(input);
	}
	
	public void addKey(InputKey input) {
		mKeyQueue.add(input);
	}
	
	public InputXY getNextXY() {
		if(!mClickQueue.isEmpty()) {
			return mClickQueue.removeFirst();
		}
		return null;
	}
	
	public InputKey getNextKey() {
		if(!mKeyQueue.isEmpty()) {
			return mKeyQueue.removeFirst();
		}
		return null;
	}
	
	public KeyEventListener getKeyListener() {
		return mKeyEventListener;
	}
	
	public class KeyEventListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent event) {
			mKeyQueue.add(new InputKey(event));
		}

		@Override
		public void keyReleased(KeyEvent event) {
		}

		@Override
		public void keyTyped(KeyEvent event) {
		}	
	}
}
