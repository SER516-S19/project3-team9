package controller;

import java.util.ArrayList;

import model.Question;
import view.InputView;

public class Controller {
	
	private InputView frame;
	private ArrayList<Question> questions;
	
	public Controller() {
		questions = new ArrayList<Question>();
		frame = new InputView(this);
		frame.setVisible(true);
	}

	public void storeQuestion(Question question) {
		System.out.println(question.getDescription());
		System.out.println(question.getOption1());
		System.out.println(question.getOption2());
		System.out.println(question.getOption3());
		System.out.println(question.getOption4());
		System.out.println(question.getCorrectOption());
		
		questions.add(question);
	}
	
	// TODO Write a quiz inside json file.
	public void writeQuizToFilePath(String path) {
		System.out.println("Store/quiz/somewhere/as/json/string.");
	}
}
