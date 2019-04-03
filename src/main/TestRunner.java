package main;
import java.util.ArrayList;

import javax.swing.JFrame;

import controller.QuizChecker;
import model.Question;

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
        
        ArrayList<Question> a = new ArrayList<Question>();
        a.add(new Question("q1","1","2","3","4",(short)(2)));
        a.add(new Question("q2","b","bla","blabla","blablabla",(short)(1)));
        a.add(new Question("q3","this","is","test","case",(short)(4)));
        QuizChecker q = new QuizChecker(a,f);
        q.sendQuestions();
    }
}