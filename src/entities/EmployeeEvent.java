package entities;

import java.util.Random;

public class EmployeeEvent {

	private final String[] EVENT_TYPES = {"LETTER", "CALL", "EMAIL", "FACEBOOK", "TWITTER"};
	private final String mChosenEvent;
	
	public EmployeeEvent() {
		Random r = new Random();
		mChosenEvent = EVENT_TYPES[r.nextInt(EVENT_TYPES.length)];
	}
	
	public String getEventType() {
		return mChosenEvent;
	}
}
