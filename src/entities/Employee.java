package entities;

import java.util.ArrayList;
import java.util.Random;

import main.Sprite;

public class Employee extends Sprite {

	private int mSalary;
	private int mTwitterSkill, mFacebookSkill, mLetterSkill, mEmailSkill,
			mPhoneSkill;
	private String employeeTypes[] = { "Novice", "Amatuer", "Skilled",
			"Professional", "Master" };
	private String employeeType;
	private double skill;
	private int maxSkillLevel;
	private int id;

	public Employee() {
		int i = (int) Math.random() * 4;
		employeeType = employeeTypes[i];

		if (employeeType == "Novice") {
			mTwitterSkill = (int) Math.random() * 25 + 1;
			mFacebookSkill = (int) Math.random() * 25 + 1;
			mLetterSkill = (int) Math.random() * 25 + 1;
			mEmailSkill = (int) Math.random() * 25 + 1;
			mPhoneSkill = (int) Math.random() * 25 + 1;
			mSalary = 50;
			maxSkillLevel = 25;
		}

		if (employeeType == "Amatuer") {
			mTwitterSkill = (int) Math.random() * 30 + 21;
			mFacebookSkill = (int) Math.random() * 30 + 21;
			mLetterSkill = (int) Math.random() * 30 + 21;
			mEmailSkill = (int) Math.random() * 30 + 21;
			mPhoneSkill = (int) Math.random() * 30 + 21;
			mSalary = 100;
			maxSkillLevel = 50;
		}

		if (employeeType == "Skilled") {
			mTwitterSkill = (int) Math.random() * 30 + 41;
			mFacebookSkill = (int) Math.random() * 30 + 41;
			mLetterSkill = (int) Math.random() * 30 + 41;
			mEmailSkill = (int) Math.random() * 30 + 41;
			mPhoneSkill = (int) Math.random() * 30 + 41;
			mSalary = 250;
			maxSkillLevel = 70;
		}

		if (employeeType == "Professional") {
			mTwitterSkill = (int) Math.random() * 35 + 61;
			mFacebookSkill = (int) Math.random() * 35 + 61;
			mLetterSkill = (int) Math.random() * 35 + 61;
			mEmailSkill = (int) Math.random() * 35 + 61;
			mPhoneSkill = (int) Math.random() * 35 + 61;
			mSalary = 500;
			maxSkillLevel = 95;
		}
		if (employeeType == "Master") {
			mTwitterSkill = (int) Math.random() * 20 + 81;
			mFacebookSkill = (int) Math.random() * 20 + 81;
			mLetterSkill = (int) Math.random() * 20 + 81;
			mEmailSkill = (int) Math.random() * 20 + 81;
			mPhoneSkill = (int) Math.random() * 20 + 81;
			mSalary = 1000;
			maxSkillLevel = 100;
		}
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
