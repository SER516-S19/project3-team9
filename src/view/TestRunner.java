package src.view;

import javax.swing.JFrame;
import src.model.Question;

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
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        Question q = new Question();
        q.setDescription("Some question title that defines this question and some other blah blah blah text.... It can be multiline so this is a new line\n And this is another new line");
        q.setOption1("First Option for this question which is too long...\n it is still going on... \nand still you are reading it.... because it is not wrapped\nOh more text is here....");
        q.setOption2("Short Option");
        q.setOption3("3");
        q.setOption4("Blah Blah Blah Blah Blah Blah");
        q.setCorrectOption((short)2);

        // showing last question
        int flag = QuestionAttemptTemplate.showQuestion(f, q, true);
        if(flag == QuestionAttemptTemplate.CORRECT_ANSWER)
            System.out.println("Correct Answer !");
        else if(flag == QuestionAttemptTemplate.INCORRECT_ANSWER)
            System.out.println("Incorrect Answer !");
        else if(flag == QuestionAttemptTemplate.GAVE_UP){
            System.out.println("Student Gave Up !");
        }

        flag = QuestionAttemptTemplate.showQuestion(f, q);
        if(flag == QuestionAttemptTemplate.CORRECT_ANSWER)
            System.out.println("Correct Answer !");
        else if(flag == QuestionAttemptTemplate.INCORRECT_ANSWER)
            System.out.println("Incorrect Answer !");
        else if(flag == QuestionAttemptTemplate.GAVE_UP){
            System.out.println("Student Gave Up !");
        }
    }
}