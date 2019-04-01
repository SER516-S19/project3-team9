
import java.util.ArrayList;
import java.util.Random;

public class QuizChecker {
	private Quiz quiz;
	private ArrayList<QuestionStub> questions;
	private QuestionAttemptTemplate template;
	
	public QuizChecker(QuizReader reader,QuizList list,QuestionAttemptTemplate template){
		String quiz_title = list.getSelectedQuiz();
		this.template = template;
		quiz = reader.readQuiz(quiz_title);
		questions = quiz.getQuestions();
		template.showQuestion(questions.get(0));
	}
	
	public void retryQuestions(Question q){
		if(!template.showQuestions(q)) {
			Random r = new Random();
			int randomIndex = r.nextInt(questions.size());
			template.showQuestion(questions.get(randomIndex));
		}
	}
}
