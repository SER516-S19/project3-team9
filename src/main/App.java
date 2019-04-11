package src.main;

import java.awt.EventQueue;

import javax.swing.JFrame;

import src.controller.Instructor;
import src.controller.QuizChecker;
import src.utility.QuizReader;
import src.view.QuizList;

/**
 * Entry point of application.
 *
 * @author Shivam Verma
 * @version 1.0
 */

public class App {

	/** String stating the title of the application. */
	private static final String FRAME_TITLE = "Quiz App";

	/**
	 * Function to launch the application.
	 *
	 * @param args String arguments passed at runtime
	 */

	public static void main(String args[]) {

		String filename = args[0];
		String app = args[1];

		if (app.equals("P")) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						new Instructor(filename);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		else if (app.equals("S")) {

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
}
