
import java.util.ArrayList;
import java.util.Random;

import javax.swing.WindowConstants;
/**
 * students can try questions until they answered all questions, and if their answer is wrong, they retry this question.
 * @author      Jiayan Wang
 * @version     1.0
 */

public class QuizChecker {
	private ArrayList<QuestionStub> questions;
	private QuestionAttemptTemplate template;
	private boolean giveup;
	
	public QuizChecker(QuestionAttemptTemplate template,ArrayList<QuestionStub> q ){
		questions = q;
		this.template = template;
		giveup = false;
	}
	
	public void tryQuestions(){
		Random r = new Random();
		while(questions.size()!=0 && giveup != true) {
			int randomIndex = r.nextInt(questions.size());
			while(!template.showQuestion(questions.get(randomIndex)));
			questions.remove(randomIndex);
		}	
	}

	public boolean isGiveup() {
		return giveup;
	}	
}
