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
 * @version 1.3
 */
public class Instructor {

	private JFrame profFrame;
	private MakeQuestionView makeQuestionPanel;
	private ArrayList<Question> questions;
	private static final String FRAME_TITLE = "Quiz Monster";
	private String filename;

	public Instructor(String filename) {
		this.filename = filename;
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
			JOptionPane.showMessageDialog(null, "Empty Q&A Detected...");
			return;
		}
		if (isEnd) {
			writeQuizToFilePath(makeQuestionPanel.getTitle());
		} else {
			makeQuestionPanel.refreshPage(questions.size() + 1);
		}
	}

	private void writeQuizToFilePath(String quizTitle) {
		int input = JOptionPane.showOptionDialog(null, "Save it now?", "Hint", JOptionPane.YES_NO_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, null, null);
		if (input == JOptionPane.OK_OPTION) {
			filename = filename + quizTitle + ".json";
			Quiz quiz = new Quiz(questions);
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json = gson.toJson(quiz);
			try {
				File file = new File(filename);
				FileWriter writer = new FileWriter(file);
				writer.write(json);
				writer.close();
				ProfLandingView landingPanel = new ProfLandingView(this);
				profFrame.setContentPane(landingPanel);
				profFrame.revalidate();
			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Something goes wrong... Not save.");
			}
		}
	}

	private Boolean checkIsValid(Question question) {
		if (question.getTitle().equals("") | question.getOption1().equals("") | question.getOption2().equals("")
				| question.getOption3().equals("") | question.getOption4().equals("")) {
			return false;
		}
		return true;
	}
}
