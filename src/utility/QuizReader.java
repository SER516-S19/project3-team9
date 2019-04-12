package src.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import src.model.Question;
import src.model.Quiz;

/**
 * Class that reads information from quiz JSON files saved in the quiz folder
 * and stores information into a Quiz object.
 *
 * @author Qianru (Ruby) Zhao
 * @verson 1.0
 */
public class QuizReader {

	/**
	 * Constructor for the QuizReader class
	 */
	public QuizReader() { }

	/**
	 * Reads question title, options, and correct answer from the specified quiz's
	 * JSON file. Takes a quiz name and creates a JsonReader object to pass to
	 * createQuiz.
	 * 
	 * @param quizName String representing the name of the quiz file (ie "testQuiz",
	 *                 no ".json")
	 * @throws IOException
	 */
	public Quiz readQuiz(String quizName, String folderPath) throws IOException {
		String filename = folderPath + quizName + ".json";
		File folder = new File(filename);
		System.out.println(folder.getAbsolutePath());
		JsonReader reader = new JsonReader(new FileReader(filename));

		return createQuiz(reader, quizName);
	}

	/**
	 * Takes a JsonReader object and parses out the JSON file. Stores information
	 * read from file into a Quiz object.
	 * 
	 * @param reader   JsonReader object specifying the quiz to read from
	 * @param quizName String name of quiz file
	 * @return Quiz object requested by readQuiz
	 * @throws IOException
	 */
	private Quiz createQuiz(JsonReader reader, String quizName) throws IOException {
		ArrayList<Question> questionList = new ArrayList<>();
		Gson gson = new Gson();
		Quiz quiz = gson.fromJson(reader, Quiz.class);

		for (int i = 0; i < quiz.getQuestions().size(); i++) {
			Question question = quiz.getQuestions().get(i);
			questionList.add(question);
		}
		return new Quiz(questionList);
	}
}