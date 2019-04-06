
package src.controller;

import java.util.ArrayList;

import javax.swing.JFrame;

import src.model.Question;
import src.view.MakeQuestionView;
import src.view.ProfTitleView;;

/**
 * The controller of the inputs from user including store question
 * and write the quiz into the JSON file.
 *
 * @author Yu-Ting Tsao, Xiangwei Zheng
 * @version 1.0
 */
public class Instructor {
	
	private JFrame profFrame;
	private MakeQuestionView makeQuestionPanel;
	
	private ArrayList<Question> questions;
	
	private static final String FRAME_TITLE = "Quiz Monster";
	
	public Instructor() {
		questions = new ArrayList<Question>();
		setupFrame();
		editTitlePage();
	}
	
	private void setupFrame() {
		profFrame = new JFrame();
		profFrame.setTitle(FRAME_TITLE);
		profFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		profFrame.setBounds(350, 50, 700, 600);
		profFrame.setVisible(true);
	}
	
	private void editTitlePage() {
		ProfTitleView titlePanel = new ProfTitleView(this);
		profFrame.setContentPane(titlePanel);
	}
	
	public void gotoQuestion(String quizTitle, Boolean gotoQues) {
		makeQuestionPanel = new MakeQuestionView(quizTitle, this);
		profFrame.setContentPane(makeQuestionPanel);
		profFrame.revalidate();
	}

	public void exitQuiz(Boolean exitQuiz) {
		System.exit(0);
	}
	
	public void storeQuestion(Question question, Boolean isEnd) {
		if (checkIsValid(question)) {
			questions.add(question);
		} else {
			// TODO Alert
			return;
		}
		if (isEnd) {
			writeQuizToFilePath("Store/quiz/somewhere/as/json/string.");
		} else {
			makeQuestionPanel.refreshPage(questions.size() + 1);
		}
	}
	
	private void writeQuizToFilePath(String path) {
		System.out.println("My store path: " + path);
		// TODO Go to firework finish page!!!!!
	}
	
	private Boolean checkIsValid(Question question) {
		// TODO Check empty or not for fields.
		return true;
	}
}
