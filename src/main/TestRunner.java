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
        QuizChecker q = new QuizChecker(qr,f,qlist);
    }
}