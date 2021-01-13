package com.techmania.remoteservice.bean;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DropDowns implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9204194573527948949L;
	private List<KeyAndValue> educationLevel;
	private List<KeyAndValue> graduationYear;
	private List<KeyAndValue> countries;
	private List<KeyAndValue> states;
	private List<KeyAndValue> classTimings;
	private List<KeyAndValue> militaryTimings;

	public List<KeyAndValue> getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(List<KeyAndValue> educationLevel) {
		this.educationLevel = educationLevel;
	}

	public List<KeyAndValue> getGraduationYear() {
		return graduationYear;
	}

	public void setGraduationYear(List<KeyAndValue> graduationYear) {
		this.graduationYear = graduationYear;
	}

	public List<KeyAndValue> getCountries() {
		return countries;
	}

	public void setCountries(List<KeyAndValue> countries) {
		this.countries = countries;
	}

	public List<KeyAndValue> getStates() {
		return states;
	}

	public void setStates(List<KeyAndValue> states) {
		this.states = states;
	}

	public List<KeyAndValue> getClassTimings() {
		return classTimings;
	}

	public void setClassTimings(List<KeyAndValue> classTimings) {
		this.classTimings = classTimings;
	}

	public List<KeyAndValue> getMilitaryTimings() {
		return militaryTimings;
	}

	public void setMilitaryTimings(List<KeyAndValue> militaryTimings) {
		this.militaryTimings = militaryTimings;
	}
	
	

}
