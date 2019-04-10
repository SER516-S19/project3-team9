package src.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import src.model.Question;
import src.model.Quiz;
import src.utility.QuizReader;
import src.view.QuestionAttemptTemplate;
import src.view.QuizList;
import src.view.SelectQuizTitle;;
/**
 * students can try questions until they answered all questions, 
 * and if their answer is wrong, they can retry this question.
 * @author      Jiayan Wang
 * @version     1.0
 */

/**
 * @author JW
 *
 */
public class QuizChecker {
	private ArrayList<String> quizzes;
	private LinkedBlockingQueue<Question> questions;
	private SelectQuizTitle quiz_title;
	private QuizReader quiz_reader;
	private QuizList quiz_list;
	private JFrame frame;
	
	public QuizChecker(QuizReader qr,JFrame frame, QuizList qlist){
		quiz_list = qlist;
		quiz_reader = qr;
		quizzes = qlist.readQuizList();
		questions = new LinkedBlockingQueue<Question>();
		this.frame = frame;
	}
	
	/**
	 * send the questions to the template,and show the view 
	 * until the question list is empty or student gives up.
	 */
	public void sendQuestions(){
		if(!questions.isEmpty()) {
			Question question = questions.poll();
			int flag = -1;
			if(questions.size()==0) {
				flag = QuestionAttemptTemplate.showQuestion(frame, question,true);
			} else {
				 flag = QuestionAttemptTemplate.showQuestion(frame, question);
			}
				 if(flag == QuestionAttemptTemplate.CORRECT_ANSWER) {
					 System.out.println("correct");
					 sendQuestions();
				 } else if(flag == QuestionAttemptTemplate.INCORRECT_ANSWER){
					 System.out.println("incorrect");
					 questions.add(question);
					 sendQuestions();
				 } else if(flag == QuestionAttemptTemplate.GAVE_UP) {
					 System.out.println("giveup");
				 }
		}
	}
  
	/**
	 * This method get the quiz title from the QuizTitle class,
	 * and then get the quiz object which has same title in the quiz list.
	 * Based on this quiz object, it will initialize the questions queue
	 * and send this questions queue to the Question template.
	 * 
	 * @param title it will be sent by the QuizTitle class
	 */
	public void selectedTitle(String title) {
		System.out.println("get selected title " + title);
		try {
			Quiz quiz = quiz_reader.readQuiz(title);
			ArrayList<Question> question_list = quiz.getQuestions();
			for(Question q : question_list) {
				questions.add(q);
			}
			sendQuestions();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * run the select title UI.
	 */
	public void run() {
		quiz_title = new SelectQuizTitle(frame,this);
	}

	/**
	 * get the quiz's title.
	 * @return the quiz titles from quizReader
	 */
	public ArrayList<String> getQuizzes() {
		return quizzes;
	}
}