package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class InputQueue {

	private static ArrayList<InputXY> mXYList;
	private static ArrayList<InputKey> mPressedKeyList;
	
	private KeyEventListener mKeyEventListener;
	
	public InputQueue() {
		mXYList = new ArrayList<InputXY>();
		mPressedKeyList = new ArrayList<InputKey>();
		
		mKeyEventListener = new KeyEventListener();
	}
	
	public void addXY(InputXY input) {
		//mClickQueue.add(input);
		mXYList.add(input);
	}
	
	public void removeXY(InputXY input) {
		mXYList.remove(input);
	}
	
	public void addKey(InputKey input) {
		input.setPressed(true);
		mPressedKeyList.add(input);
	}
	
	public void removeKey(InputKey input) {
		input.setPressed(false);
		mPressedKeyList.remove(input);
	}
	
	public ArrayList<InputKey> getPressedKeys() {
		return mPressedKeyList;
	}
	
	public ArrayList<InputXY> getXYs() {
		return mXYList;
	}
	
	public KeyEventListener getKeyListener() {
		return mKeyEventListener;
	}
	
	private class KeyEventListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent event) {
			InputKey key = new InputKey(event);
			
			// Iterator removal prevents concurrent modification exceptions...
			Iterator<InputKey> iterator = mPressedKeyList.iterator();
			while(iterator.hasNext()) {
				InputKey checkKey = iterator.next();
				if(key.equals(checkKey)) {
					return;
				}
			}
			
			key.setPressed(true);
			addKey(key);
		}

		@Override
		public void keyReleased(KeyEvent event) {
			InputKey key = new InputKey(event);
			
			// Iterator removal prevents concurrent modification exceptions...
			Iterator<InputKey> iterator = mPressedKeyList.iterator();
			while(iterator.hasNext()) {
				InputKey pressedKey = iterator.next();
				if(key.equals(pressedKey)) {
					iterator.remove();
				}
			}
		}

		@Override
		public void keyTyped(KeyEvent event) {
		}
	}
}
