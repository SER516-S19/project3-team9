package src.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.JFrame;

import src.model.Question;
import src.model.Quiz;
import src.utility.QuizReader;
import src.view.EndOfTheQuiz;
import src.view.QuestionAttemptTemplate;
import src.view.QuizList;
import src.view.SelectQuizTitle;

/**
 * This is the controller class which creates all view components and control
 * the transition between all views.
 * 
 * @author Jiayan Wang
 * @version 1.0
 */

public class QuizChecker {
	private ArrayList<String> quizzes;
	private LinkedBlockingQueue<Question> questions;
	private SelectQuizTitle quiz_title;
	private QuizReader quiz_reader;
	private EndOfTheQuiz end_quiz;
	private JFrame frame;

	public QuizChecker(QuizReader qr, JFrame frame, QuizList qlist) {
		quizzes = qlist.readQuizList();
		quiz_reader = qr;
		this.frame = frame;
		questions = new LinkedBlockingQueue<Question>();
		end_quiz = new EndOfTheQuiz(this, frame);
		quiz_title = new SelectQuizTitle(frame, this);
	}

	/**
	 * send the questions to the template,and show the view until the question list
	 * is empty or student gives up.
	 */
	public void sendQuestions() {
		if (!questions.isEmpty()) {
			Question question = questions.poll();
			int flag = -1;
			if (questions.size() == 0) {
				flag = QuestionAttemptTemplate.showQuestion(frame, question, true);
			} else {
				flag = QuestionAttemptTemplate.showQuestion(frame, question);
			}

			if (flag == QuestionAttemptTemplate.CORRECT_ANSWER) {
				sendQuestions();
			} else if (flag == QuestionAttemptTemplate.INCORRECT_ANSWER) {
				questions.add(question);
				sendQuestions();
			} else if (flag == QuestionAttemptTemplate.GAVE_UP) {
				frame.setVisible(true);
				quiz_title.show();
			}
		}
	}

	/**
	 * This method get the selected quiz title from the QuizTitle class, and then
	 * get the quiz object based on the quiz title. Then, it will initialize the
	 * questions queue from quiz object and send this questions queue to the
	 * Question template.
	 * 
	 * @param title it will be sent by the QuizTitle class
	 */
	public void selectedTitle(String title) {
		frame.setVisible(false);
		questions.clear();
		try {
			Quiz quiz = quiz_reader.readQuiz(title);
			ArrayList<Question> question_list = quiz.getQuestions();
			for (Question q : question_list) {
				questions.add(q);
			}
			sendQuestions();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * return to the select title screen.
	 */
	public void returnToTitle() {
		quiz_title.show();
	}

	/**
	 * get the quiz's title.
	 * 
	 * @return the quiz's titles get from quizReader
	 */
	public ArrayList<String> getQuizzes() {
		return quizzes;
	}
}