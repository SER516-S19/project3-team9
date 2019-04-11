package src.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import src.controller.QuizChecker;
import src.utility.QuizReader;
import src.view.EndOfTheQuiz;
import src.view.QuizList;

/**
 * The launcher class for Student side of application.
 *
 * @author Sarthak Tiwari <sarthak.tiwari@asu.edu>
 * @author Jiayan Wang
 * @author Bhavana Vakkalagadda
 * @version 1.0
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
		JFrame j = new JFrame();
		QuizList ql = new QuizList();
		QuizReader qr = new QuizReader();
		QuizChecker qc = new QuizChecker(qr, j, ql);
		JFrame f = new EndOfTheQuiz(qc, j);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EndOfTheQuiz frame = new EndOfTheQuiz(qc, f);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

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
