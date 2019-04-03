package src.controller;

import java.util.ArrayList;
import src.model.Question;
import src.view.MakeQuestionView;;

/**
 * The controller of the inputs from user including store question
 * and write the quiz into the JSON file.
 *
 * @author Yu-Ting Tsao
 * @version 1.0
 */
public class Instructor {
	
	private MakeQuestionView frame;
	private ArrayList<Question> questions;
	
	public Instructor() {
		questions = new ArrayList<Question>();
		frame = new MakeQuestionView(this);
		frame.setVisible(true);
	}

	public void storeQuestion(Question question) {
		
		System.out.println(question.getDescription());
		System.out.println(question.getOption1());
		System.out.println(question.getOption2());
		System.out.println(question.getOption3());
		System.out.println(question.getOption4());
		System.out.println("The answer is No. " + question.getCorrectOption());
		questions.add(question);
		frame.refreshPage(questions.size() + 1);
	}
	
	// TODO Write a quiz inside JSON file.
	public void writeQuizToFilePath(String path) {
		System.out.println("Store/quiz/somewhere/as/json/string.");
	}
}
