package controller;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import model.Question;
import view.QuestionAttemptTemplate;
/**
 * students can try questions until they answered all questions, 
 * and if their answer is wrong, they can retry this question.
 * @author      Jiayan Wang
 * @version     1.0
 */

public class QuizChecker {
	private LinkedBlockingQueue<Question> questions;
	private JFrame frame;
	
	public QuizChecker(ArrayList<Question> questionList,JFrame frame){
		questions = new LinkedBlockingQueue<Question>();
		for(Question q : questionList) {
			questions.add(q);
		}
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
}
