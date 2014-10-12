package entities;

import java.util.Random;

import main.Sprite;

public class Employee extends Sprite {

	private String[] forename = {"a","b","c","d","e"};
	private String[] surname = {"a","b","c","d","e"};
	Random random = new Random();
	
	private String name;
	private int mSalary;
	private int mTwitterSkill, mFacebookSkill, mLetterSkill, mEmailSkill,
			mPhoneSkill;
	private String employeeTypes[] = { "Novice", "Amatuer", "Skilled",
			"Professional", "Master" };
	private String employeeType;
	private double skill;
	private int maxSkillLevel;
	private int id;
	
	private int mDirection;

	public Employee() {
		name = forename[(int) (random.nextInt(4))] + " " + surname[(int) (random.nextInt(4))];
		int i = (int) ( random.nextInt(4) );
		employeeType = employeeTypes[i];

		if (employeeType == "Novice") {
			mTwitterSkill = (int) (random.nextInt(25));
			mFacebookSkill = (int) (random.nextInt(25));
			mLetterSkill = (int) (random.nextInt(25));
			mEmailSkill = (int) (random.nextInt(25));
			mPhoneSkill = (int)( random.nextInt(25));
			mSalary = 50;
			maxSkillLevel = 25;
		}

		if (employeeType == "Amatuer") {
			mTwitterSkill = (int) (random.nextInt(30) + 20);
			mFacebookSkill = (int) (random.nextInt(30) + 20);
			mLetterSkill = (int) (random.nextInt(30) + 20);
			mEmailSkill = (int) (random.nextInt(30) + 20);
			mPhoneSkill = (int) (random.nextInt(30) + 20);
			mSalary = 100;
			maxSkillLevel = 50;
		}

		if (employeeType == "Skilled") {
			mTwitterSkill = (int) (random.nextInt(30) + 40);
			mFacebookSkill = (int) (random.nextInt(30) + 40);
			mLetterSkill = (int) (random.nextInt(30) + 40);
			mEmailSkill = (int) (random.nextInt(30) + 40);
			mPhoneSkill = (int) (random.nextInt(30) + 40);
			mSalary = 250;
			maxSkillLevel = 70;
		}

		if (employeeType == "Professional") {
			mTwitterSkill = (int) (random.nextInt(35) + 60);
			mFacebookSkill = (int) (random.nextInt(35) + 60);
			mLetterSkill = (int) (random.nextInt(35) + 60);
			mEmailSkill = (int) (random.nextInt(35) + 60);
			mPhoneSkill = (int)(random.nextInt(35) + 60);
			mSalary = 500;
			maxSkillLevel = 95;
		}
		if (employeeType == "Master") {
			mTwitterSkill = (int) (random.nextInt(20) + 80);
			mFacebookSkill = (int) (random.nextInt(20) + 80);
			mLetterSkill = (int) (random.nextInt(20) + 80);
			mEmailSkill = (int) (random.nextInt(20) + 80);
			mPhoneSkill = (int) (random.nextInt(20) + 80);
			mSalary = 1000;
			maxSkillLevel = 100;
		}
	}
	
	public void setDireciton(int direction) {
		mDirection = direction;
		
		switch(mDirection) {
		case 0:
			this.setImage("employee_up.png");
			break;
		case 1:
			this.setImage("employee_left.png");
			break;
		case 2:
			this.setImage("employee_down.png");
			break;
		case 3:
			this.setImage("employee_right.png");
			break;
		}
	}

	public String getName(){
		return name;
	}
	public int getMaxSkillLevel() {
		return maxSkillLevel;
	}

	public void setMaxSkillLevel(int i) {
		maxSkillLevel = i;
	}

	public int getTwitterSkill() {
		return mTwitterSkill;
	}

	public void setTwitterSkill(int i) {
		mTwitterSkill = i;
	}

	public int getFacebookSkill() {
		return mFacebookSkill;
	}

	public void setFacebookSkill(int i) {
		mFacebookSkill = i;
	}

	public int getLetterSkill() {
		return mLetterSkill;
	}

	public void setLetterSkill(int i) {
		mLetterSkill = i;
	}

	public int getEmailSkill() {
		return mEmailSkill;
	}

	public void setEmailSkill(int i) {
		mEmailSkill = i;
	}

	public int getPhoneSkill() {
		return mPhoneSkill;
	}

	public void setPhoneSkill(int i) {
		mPhoneSkill = i;
	}

	public void setId(int i) {
		id = i;
	}

	public int getId() {
		return id;
	}
}
