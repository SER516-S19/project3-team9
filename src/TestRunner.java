import java.util.ArrayList;

import javax.swing.JFrame;

/**
 * Form to show a question and navaigation buttion and to give user
 * functionality to select one of the options.
 * @author      Sarthak Tiwari <sarthak.tiwari@asu.edu>
 * @version     1.0
 */
public class TestRunner {

    public static void main(String[] args) {

        JFrame f = new JFrame();

        f.setSize(500, 500);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        QuizReader reader = new QuizReader();
        QuizList list = new QuizList();
        SelectQuizTitle title = new SelectQuizTitle(f);
        QuestionAttemptTemplate template = new QuestionAttemptTemplate(f);
        ArrayList<QuestionStub> q = new ArrayList<QuestionStub>();
        q.add(new QuestionStub());
        QuestionStub s2 = new QuestionStub();
        s2.option1 = "1";
        s2.option2 = "2";
        s2.option3 = "3";
        s2.option4 = "4";
        s2.correctOption = 1;
        q.add(s2);
        q.add(new QuestionStub());
        QuizChecker checker = new QuizChecker(template,q);
        checker.tryQuestions();
    }

}