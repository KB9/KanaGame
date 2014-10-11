package entities;

import java.util.ArrayList;

import main.Sprite;

public class Employee extends Sprite {
	
	private ArrayList<EmployeeEvent> eventList;
	
	public Employee() {
		eventList = new ArrayList<EmployeeEvent>();
	}
}
