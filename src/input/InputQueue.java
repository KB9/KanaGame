package input;

import java.util.LinkedList;

public class InputQueue {

	private static LinkedList<InputObject> mInputQueue;
	public KeyEventListener mKeyEventListener;
	
	public InputQueue() {
		mInputQueue = new LinkedList<InputObject>();
	}
	
	public void add(InputObject input) {
		mInputQueue.add(input);
	}
	
	public InputObject getNext() {
		if(!mInputQueue.isEmpty()) {
			return mInputQueue.removeFirst();
		}
		return null;
	}
}
