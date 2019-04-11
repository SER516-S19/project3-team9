package src.main;

import javax.swing.JFrame;
import src.controller.QuizChecker;
import src.utility.QuizReader;
import src.view.QuizList;

/**
 * The launcher class for Student side of application.
 *
 * @author	Sarthak Tiwari <sarthak.tiwari@asu.edu>
 * @author	Jiayan Wang
 * @version	1.0
 */
public class StudentRunner {

	/** String stating the title of the application. */
	private static final String FRAME_TITLE = "Quiz Monster";

	/**
	 * Function to launch the application.
	 *
	 * @param args String arguments passed at runtime
	 */
    public static void main(final String[] args) {

        JFrame studentFrame = new JFrame();
        studentFrame = new JFrame(FRAME_TITLE);

        studentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        studentFrame.setBounds(350, 50, 700, 600);

		QuizReader quizReader = new QuizReader();
        QuizList quizList = new QuizList();
        new QuizChecker(quizReader, studentFrame, quizList);

        studentFrame.setVisible(true);
    }
}
