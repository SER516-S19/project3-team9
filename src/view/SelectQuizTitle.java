package src.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Component;


/**
 * Class create drop down menu for quizzes
 *
 * @author Shashidhar Reddy Vanteru
 * 
 */

public class SelectQuizTitle {

	SelectQuizTitle() {

		JFrame quiz = new JFrame("Quiz");
		quiz.setVisible(true);
		quiz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		quiz.setSize(500, 500);
		quiz.setLocation(430, 100);

		JPanel quizpanel = new JPanel();
		quizpanel.setLayout(new BoxLayout(quizpanel, BoxLayout.Y_AXIS));

		quiz.add(quizpanel);

		JLabel message = new JLabel("Select the quiz from choices");
		message.setAlignmentX(Component.CENTER_ALIGNMENT);

		quizpanel.add(message);

		String[] choices = { "CHOICE 1", "CHOICE 2", "CHOICE 3", "CHOICE 4", "CHOICE 5", "CHOICE 6" };

		final JComboBox<String> cb = new JComboBox<String>(choices);

		cb.setMaximumSize(cb.getPreferredSize());
		cb.setAlignmentX(Component.CENTER_ALIGNMENT);
		quizpanel.add(cb);

		JButton btn = new JButton("OK");
		btn.setAlignmentX(Component.CENTER_ALIGNMENT);
		quizpanel.add(btn);

		quiz.setVisible(true);

	}
}