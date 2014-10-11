package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

public class InputQueue {

	private static ArrayList<InputXY> mXYList;
	private static ArrayList<InputKey> mPressedKeyList;
	
	private KeyEventListener mKeyEventListener;
	private MouseEventListener mMouseEventListener;
	
	public InputQueue() {
		mXYList = new ArrayList<InputXY>();
		mPressedKeyList = new ArrayList<InputKey>();
		
		mKeyEventListener = new KeyEventListener();
		mMouseEventListener = new MouseEventListener();
	}
	
	public void addXY(InputXY input) {
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
	
	public MouseEventListener getMouseListener() {
		return mMouseEventListener;
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
	
	private class MouseEventListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent event) {
		}

		@Override
		public void mouseEntered(MouseEvent event) {
		}

		@Override
		public void mouseExited(MouseEvent event) {
		}

		@Override
		public void mousePressed(MouseEvent event) {
			addXY(new InputXY(event));
		}

		@Override
		public void mouseReleased(MouseEvent event) {
		}
		
	}
}
