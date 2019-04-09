package src.model;

import java.util.ArrayList;

/**
 * Class to store all the information regarding a quiz.
 *
 * @author Shivam Verma
 * @version 2.0
 */

public class Quiz {

	private ArrayList<Question> questions;

	/**
	 * Parametrised constructor with all required attributes.
	 *
	 * @param questions: ArrayList of Question objects
	 */
	public Quiz(ArrayList<Question> questions) {
		super();
		this.questions = questions;
	}

	/**
	 * @param titleInput : String with the question title
	 */

	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}
	
	/**
	* @return List<Question> : list of object of type Question
	*/	
	
	public ArrayList<Question> getQuestions() {
		return questions;
	}
}
