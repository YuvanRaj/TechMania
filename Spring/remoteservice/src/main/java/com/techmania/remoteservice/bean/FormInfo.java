package com.techmania.remoteservice.bean;

import java.util.List;

public class FormInfo extends BaseFormInfo{

	private List<Question> questions;

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

}
