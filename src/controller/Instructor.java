package src.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import src.model.Question;
import src.model.Quiz;
import src.view.MakeQuestionView;
import src.view.ProfLandingView;
import src.view.ProfTitleView;

/**
 * The controller of the inputs from user including store question and write the
 * quiz into the JSON file.
 *
 * @author Yu-Ting Tsao, Xiangwei Zheng, Aditya Vikram, Shivam Verma
 * @version 1.2
 */
public class Instructor {
	
	private final String FOLDER_PATH = "./quizzes/";
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
	
	public void landingPage() {
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
			writeQuizToFilePath(makeQuestionPanel.getTitle());
			JOptionPane.showMessageDialog(new JFrame(), "Quiz Created",
					"Message", JOptionPane.INFORMATION_MESSAGE);
			makeQuestionPanel.navigatePage();
		} else {
			makeQuestionPanel.refreshPage(questions.size() + 1);
		} 
	}

	private void writeQuizToFilePath(String quizTitle) {
		String filename = FOLDER_PATH + quizTitle + ".json";
		Quiz quiz = new Quiz(questions);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(quiz);
		System.out.println(json);
		try {
			File file = new File(filename);
			FileWriter writer = new FileWriter(file);
			writer.write(json);
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Boolean checkIsValid(Question question) {
		// TODO Check empty or not for fields.
		return true;
	}
}
