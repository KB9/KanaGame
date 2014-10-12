package entities;

import java.util.ArrayList;

import main.Panel;

public class Business {
	private int mMoney = 1000;
	private int maxStaff = 10;
	private ArrayList<Employee> currentEmployees = new ArrayList<Employee>();
	private ArrayList<Employee> hireableEmployees = new ArrayList<Employee>();
	private int employeeId;
	private int maxEmployeeCount;
	int sx = 50;

	public Business() {
		maxEmployeeCount = 10;
		employeeId = 0;
		for (int x = 0; x < 10; x++) {
			newHireableEmployee();
		}
		hireEmployee(employeeId);

	}

	public void hireEmployee(int id) {
		for (int x = 0; x < 10; x++) {
			if (hireableEmployees.get(x).getId() == id
					&& currentEmployees.size() <= maxEmployeeCount) {
				currentEmployees.add(hireableEmployees.get(x));
				hireableEmployees.remove(x);
				newHireableEmployee();
				Employee e = currentEmployees.get(currentEmployees.size() - 1);
				e.setDireciton(2);
				e.setX(sx);
				e.setY(sx);
				Panel.mLevel.addSprite(e);
				System.out.println(e.getName());
			}
		}
		sx += 10;
	}

	public void newHireableEmployee() {
		Employee e = new Employee();
		e.setId(employeeId);
		hireableEmployees.add(e);
		employeeId += 1;

	}

	public void fireEmployee(int id) {
		for (Employee e : currentEmployees) {
			if (e.getId() == id) {

				currentEmployees.remove(e);
			}
		}
	}

	public ArrayList<Employee> getHireableEmployees() {
		return hireableEmployees;

	}
	
	public ArrayList<Employee> getCurrentEmployees() {
		return currentEmployees;

	}

	public boolean getEmployeesFull() {

		if (currentEmployees.size() == maxEmployeeCount)
			return true;
		else
			return false;
	}

}
