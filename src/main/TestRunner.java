package src.main;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

import src.controller.QuizChecker;
import src.model.Question;
import src.utility.QuizReader;
import src.view.QuizList;
import src.model.Quiz;

/**
 * Form to show a question and navaigation buttion and to give user
 * functionality to select one of the options.
 * @author      Sarthak Tiwari <sarthak.tiwari@asu.edu>,Jiayan Wang
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

        QuizReader qr = new QuizReader();
        QuizList qlist = new QuizList();
        ArrayList<String> quizzes = qlist.readQuizList();
        System.out.println(quizzes);

        /*
        To be implemented:
        1. Create a QuizReader object and a QuizList object.
        2. Call the QuizList method to get a list of all quizzes in the 'quizzes' folder.
        3. Display the list in the UI page.
        4. Get user's input from the dropdown to choose a quiz.
        5. Take the name of that quiz (String) and pass it to QuizReader, which will give you the Quiz object.
        6. Generate the quiz using the Quiz object.
        */
        try {
            Quiz qz = qr.readQuiz(quizzes.get(1));

            ArrayList<Question> ques = qz.getQuestions();
            QuizChecker q = new QuizChecker(ques,f);
            q.sendQuestions();

        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}