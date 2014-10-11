package entities;

import java.util.ArrayList;

public class Business {
	private int mMoney = 1000;
	private int maxStaff = 10;
	private ArrayList<Employee> currentEmployees;
	private ArrayList<Employee> hireableEmployees;
	private int employeeId;
	
	public Business(){
		employeeId = 0;
		hireEmployee(employeeId);
		for(int x = 0; x < 10; x++){
			newHireableEmployee();
		}
	}
	
	public void hireEmployee(int id){
		for(int x = 0; x < 10; x++){
			if (hireableEmployees.get(x).getId() == id){
				currentEmployees.add(hireableEmployees.get(x));
				hireableEmployees.remove(x);
				newHireableEmployee();
			}
		}
		
	}
	
	public void newHireableEmployee(){
		Employee e = new Employee();
		e.setId(employeeId);
		hireableEmployees.add(e);
		employeeId += 1;
		
	}
	
	public void fireEmployee(int id){
		for (Employee e : currentEmployees) {
			if(e.getId() == id){
				
				currentEmployees.remove(e);
			}
		}
	}
}
