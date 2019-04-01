
import java.util.ArrayList;
import java.util.Random;
/**
 * students can try questions until they answered all questions, and if their answer is wrong, they retry this question.
 * @author      Jiayan Wang
 * @version     1.0
 */

public class QuizChecker {
	private Quiz quiz;
	private ArrayList<QuestionStub> questions;
	private QuestionAttemptTemplate template;
	private boolean giveup;
	
//	public QuizChecker(QuizReader reader,QuizList list,QuestionAttemptTemplate template){
//		String quiz_title = list.getSelectedQuiz();
//		this.template = template;
//		quiz = reader.readQuiz(quiz_title);
//		questions = quiz.getQuestions();
//		template.showQuestion(questions.get(0));
//	}
	
	public QuizChecker(QuestionAttemptTemplate template,ArrayList<QuestionStub> q ){
		questions = q;
		this.template = template;
		template.showQuestion(new QuestionStub());
		giveup = false;
	}
	
	
	public void tryQuestions(){
		Random r = new Random();
		while(questions.size()!=0 && giveup != true) {
			int randomIndex = r.nextInt(questions.size());
			while(!template.showQuestion(questions.get(randomIndex)));
			System.out.println("1");
			questions.remove(randomIndex);
		}	
	}

	public boolean isGiveup() {
		return giveup;
	}	
}
