package entities;

import java.util.ArrayList;
import java.util.Random;

import main.Sprite;

public class Employee extends Sprite {
	
	private int mSalary;
	private String mSkilledEvent;
	private ArrayList<EmployeeEvent> eventList;
	
	public Employee() {
		eventList = new ArrayList<EmployeeEvent>();
		mSkilledEvent = EmployeeEvent.EVENT_TYPES[new Random().nextInt(EmployeeEvent.EVENT_TYPES.length)];
	}
}
