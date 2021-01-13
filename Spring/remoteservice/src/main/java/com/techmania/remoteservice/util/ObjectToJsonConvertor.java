package com.techmania.remoteservice.util;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.techmania.remoteservice.bean.*;

public class ObjectToJsonConvertor<T> {

	public String convertObjectToJson(T t) {
		String json = new Gson().toJson(t);
		return json;
	}

	public void writeFile(String path, String contentToWrite) {
		try {
			FileWriter fw = new FileWriter(path);
			fw.write(contentToWrite);
			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Success...");
	}

	public static void main(String[] str) {
		ObjectToJsonConvertor obj = new ObjectToJsonConvertor();
		FormInfo form1Info = obj.getForm1Info();
		FormInfo form2Info = obj.getForm2Info();
		FormInfo form3Info = obj.getForm3Info();
		FormInfo form4Info = obj.getForm4Info();
		FormInfo form5Info = obj.getForm5Info();
		FormInfo form6Info = obj.getForm6Info();
		FormInfo form7Info = obj.getForm7Info();
		
		String json = obj.convertObjectToJson(form1Info);
		obj.writeFile("C:\\Users\\dell\\Desktop\\Free_Lancing\\SchoolOffer\\RegistrationJson\\Form1Info.json", json);
		
		json = obj.convertObjectToJson(form2Info);
		obj.writeFile("C:\\Users\\dell\\Desktop\\Free_Lancing\\SchoolOffer\\RegistrationJson\\Form2Info.json", json);
		
		json = obj.convertObjectToJson(form3Info);
		obj.writeFile("C:\\Users\\dell\\Desktop\\Free_Lancing\\SchoolOffer\\RegistrationJson\\Form3Info.json", json);
		
		json = obj.convertObjectToJson(form4Info);
		obj.writeFile("C:\\Users\\dell\\Desktop\\Free_Lancing\\SchoolOffer\\RegistrationJson\\Form4Info.json", json);
		
		json = obj.convertObjectToJson(form5Info);
		obj.writeFile("C:\\Users\\dell\\Desktop\\Free_Lancing\\SchoolOffer\\RegistrationJson\\Form5Info.json", json);
		
		json = obj.convertObjectToJson(form6Info);
		obj.writeFile("C:\\Users\\dell\\Desktop\\Free_Lancing\\SchoolOffer\\RegistrationJson\\Form6Info.json", json);
		
		json = obj.convertObjectToJson(form7Info);
		obj.writeFile("C:\\Users\\dell\\Desktop\\Free_Lancing\\SchoolOffer\\RegistrationJson\\Form7Info.json", json);
		
		
	}

	private FormInfo getForm7Info() {
		FormInfo formInfo = new FormInfo();
		formInfo.setParentId("1");
		formInfo.setFormId("7");
		formInfo.setUleadId("xzzz");
		List<Question> questions = new ArrayList<Question>();
		Question question = new Question();
		question.setQuestion("Phone Number");
		question.setAnswer("Phone Number");
		questions.add(question);
		
		question = new Question();
		question.setQuestion("Start Classes");
		question.setAnswer("Immdiately");
		questions.add(question);
		
		question = new Question();
		question.setQuestion("I acknowledge that, by clicking the checkbox as my official signature, I consent to representatives of EducationDirectory contacting me about educational opportunities via");
		question.setAnswer("Yes");
		questions.add(question);

		
		formInfo.setQuestions(questions);
		return formInfo;
	}

	private FormInfo getForm6Info() {
		FormInfo formInfo = new FormInfo();
		formInfo.setParentId("1");
		formInfo.setFormId("6");
		formInfo.setUleadId("xzzz");
		List<Question> questions = new ArrayList<Question>();
		Question question = new Question();
		question.setQuestion("US Citizen or Perm Resident");
		question.setAnswer("US Citizen");
		questions.add(question);
		
		question = new Question();
		question.setQuestion("Current or past military affiliation for you or spouse?");
		question.setAnswer("Yes");
		questions.add(question);
		
		question = new Question();
		question.setQuestion("Current or past military affiliation for you or spouse?");
		question.setAnswer("Yes");
		questions.add(question);

		question = new Question();
		question.setQuestion("Military Affiliation");
		question.setAnswer("NoMilitaryAffiliation");
		questions.add(question);
		
		formInfo.setQuestions(questions);
		return formInfo;
	}

	private FormInfo getForm5Info() {
		FormInfo formInfo = new FormInfo();
		formInfo.setParentId("1");
		formInfo.setFormId("5");
		formInfo.setUleadId("xzzz");
		List<Question> questions = new ArrayList<Question>();
		Question question = new Question();
		question.setQuestion("Zip");
		question.setAnswer("Zip");
		questions.add(question);
		
		question = new Question();
		question.setQuestion("Street Address");
		question.setAnswer("Street Address");
		questions.add(question);
		
		question = new Question();
		question.setQuestion("City");
		question.setAnswer("City");
		questions.add(question);

		question = new Question();
		question.setQuestion("State");
		question.setAnswer("State");
		questions.add(question);
		
		formInfo.setQuestions(questions);
		return formInfo;
	}

	private FormInfo getForm4Info() {
		FormInfo formInfo = new FormInfo();
		formInfo.setParentId("1");
		formInfo.setFormId("4");
		formInfo.setUleadId("xzzz");
		List<Question> questions = new ArrayList<Question>();
		Question question = new Question();
		question.setQuestion("First Name");
		question.setAnswer("First Name");
		questions.add(question);
		
		question = new Question();
		question.setQuestion("Last Name");
		question.setAnswer("Last Name");
		questions.add(question);
		
		question = new Question();
		question.setQuestion("E-mail");
		question.setAnswer("E-mail");
		questions.add(question);

		question = new Question();
		question.setQuestion("Yes, I would like to be contacted by e-mail for educational opportunities!");
		question.setAnswer("Yes");
		questions.add(question);
		
		formInfo.setQuestions(questions);
		return formInfo;
	}

	private FormInfo getForm3Info() {
		FormInfo formInfo = new FormInfo();
		formInfo.setParentId("1");
		formInfo.setFormId("3");
		formInfo.setUleadId("xzzz");
		List<Question> questions = new ArrayList<Question>();
		Question question = new Question();
		question.setQuestion("Year HS Diploma Earned");
		question.setAnswer("2020");
		questions.add(question);
		
		question = new Question();
		question.setQuestion("Age");
		question.setAnswer("16");
		questions.add(question);
		

		formInfo.setQuestions(questions);
		return formInfo;
	}

	private FormInfo getForm2Info() {
		FormInfo formInfo = new FormInfo();
		formInfo.setParentId("1");
		formInfo.setFormId("2");
		formInfo.setUleadId("xzzz");
		List<Question> questions = new ArrayList<Question>();
		Question question = new Question();
		question.setQuestion("Classroom Format");
		question.setAnswer("Online");
		questions.add(question);
		
		question = new Question();
		question.setQuestion("Do you have a computer with internet at home?");
		question.setAnswer("Yes");
		questions.add(question);
		
		question = new Question();
		question.setQuestion("Did you earn college credits earned outside the US?");
		question.setAnswer("Yes");
		questions.add(question);

		
		formInfo.setQuestions(questions);
		return formInfo;
	}

	private FormInfo getForm1Info() {
		FormInfo formInfo = new FormInfo();
		formInfo.setParentId("");
		formInfo.setFormId("1");
		formInfo.setUleadId("xzzz");
		List<Question> questions = new ArrayList<Question>();
		Question question = new Question();
		question.setQuestion("Highest Degree Earned");
		question.setAnswer("Bachlor Degree");
		questions.add(question);
		
		question = new Question();
		question.setQuestion("Degree Sought");
		question.setAnswer("Associate");
		questions.add(question);
		
		question = new Question();
		question.setQuestion("Subject of Interest");
		question.setAnswer("Business");
		questions.add(question);

		
		formInfo.setQuestions(questions);
		return formInfo;
	}
}
