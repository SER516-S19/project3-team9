package src.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.controller.QuizChecker;

/**
 * View for student to navigate to home page after the completion of the quiz.
 *
 * @author Bhavana Vakkalagadda,Jiayan Wang
 * @version 1.0
 */

public class EndOfTheQuiz extends JPanel{

	public EndOfTheQuiz(QuizChecker qz) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setSize(500, 500);

		JLabel lblNewLabel = new JLabel("End Of The Quiz");
		lblNewLabel.setBounds(116, 11, 170, 14);
		this.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Go Back To Home");
		lblNewLabel_1.setBounds(10, 109, 170, 33);
		this.add(lblNewLabel_1);

		JButton btnHome = new JButton("Home");
		btnHome.setBounds(203, 114, 89, 23);
		this.add(btnHome);

		btnHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				qz.returnToTitle();
			}
		});
	}
}
