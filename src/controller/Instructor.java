package src.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;

import src.model.Question;
import src.view.MakeQuestionView;
import src.view.ProfTitleView;
import src.view.ProfLandingView;

/**
 * The controller of the inputs from user including store question and write the
 * quiz into the JSON file.
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
////		Quiz quiz = new Quiz("Test1", questions);
////		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		String json = gson.toJson(quiz);
//		System.out.println(json);
//		try {
//			File file = new File("./quizzes/Test1.json");
//			FileWriter writer = new FileWriter(file);
//			writer.write(json);
//			writer.close();
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		System.out.println("My store path: " + path);
		// TODO Go to firework finish page!!!!!
	}

	private Boolean checkIsValid(Question question) {
		// TODO Check empty or not for fields.
		return true;
	}
}
