package src.controller;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import src.model.Question;
import src.view.MakeQuestionView;
import src.view.ProfTitleView;
import src.view.ProfLandingView;

/**
 * The controller of the inputs from user including store question
 * and write the quiz into the JSON file.
 *
 * @author Yu-Ting Tsao, Xiangwei Zheng, Aditya Vikram
 * @version 1.1
 */
public class Instructor {
	
	private JFrame profFrame;
	private MakeQuestionView makeQuestionPanel;
	
	private ArrayList<Question> questions;
	
	private static final String FRAME_TITLE = "Quiz Monster";
	
	public Instructor() {
		questions = new ArrayList<Question>();
		setupFrame();
		landingPage();
		}
	
	private void setupFrame() {
		profFrame = new JFrame();
		profFrame.setTitle(FRAME_TITLE);
		profFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		profFrame.setBounds(350, 50, 700, 600);
		profFrame.setVisible(true);
	}
	
	private void landingPage() {
		ProfLandingView landingPanel = new ProfLandingView(this);
		profFrame.setContentPane(landingPanel);
	}
	
	public void editTitlePage() {
		ProfTitleView titlePanel = new ProfTitleView(this);
		profFrame.setContentPane(titlePanel);
		profFrame.revalidate();
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
			JOptionPane.showMessageDialog(null, "Empty Q&A Detected...");
			return;
		}
		if (isEnd) {
			writeQuizToFilePath("Store/quiz/somewhere/as/json/string.");
		} else {
			makeQuestionPanel.refreshPage(questions.size() + 1);
		}
	}
	
	private void writeQuizToFilePath(String path) {
		int input = JOptionPane.showOptionDialog(null, 
				"Save it now?", "Hint", 
				JOptionPane.YES_NO_OPTION,
				JOptionPane.INFORMATION_MESSAGE,
				null, null, null);
		if(input == JOptionPane.OK_OPTION) {
			ProfLandingView landingPanel = new ProfLandingView(this);
			profFrame.setContentPane(landingPanel);
			profFrame.revalidate();
			System.out.println("My store path: " + path);
			return;
		}
	}
	
	private Boolean checkIsValid(Question question) {
		if (	question.getTitle().equals("") |
				question.getOption1().equals("") | 
				question.getOption2().equals("") |
				question.getOption3().equals("") |
				question.getOption4().equals("")) {
			return false;
		}
		return true;
	}
}
