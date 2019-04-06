package src.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import src.model.Question;
import src.model.Quiz;
import src.view.MakeQuestionView;;

/**
 * The controller of the inputs from user including store question and write the
 * quiz into the JSON file.
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

	public void storeQuestion(Question question, Boolean isEnd) {

		if (checkIsValid(question)) {
			questions.add(question);
		} else {
			// TODO Alert
			return;
		}
		System.out.println("Store question: " + question);

		if (isEnd) {
			writeQuizToFilePath("Store/quiz/somewhere/as/json/string.");
		} else {
			frame.refreshPage(questions.size() + 1);
		}
	}

	private void writeQuizToFilePath(String path) {
		Quiz quiz = new Quiz("Test1", questions);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(quiz);
		System.out.println(json);
		try {
			File file = new File("./quizzes/Test1.json");
			FileWriter writer = new FileWriter(file);
			writer.write(json);
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("My store path: " + path);
		// TODO Go to firework finish page!!!!!
	}

	private Boolean checkIsValid(Question question) {
		// TODO Check empty or not for fields.
		return true;
	}
}
