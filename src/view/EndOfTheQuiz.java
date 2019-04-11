package src.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.controller.QuizChecker;

/**
 * View for student to navigate to home page after the completion of the quiz.
 *
 * @author Bhavana Vakkalagadda 
 * @version 1.0
 */

public class EndOfTheQuiz extends JFrame {

	private JPanel contentPane = new JPanel();

	public EndOfTheQuiz(QuizChecker qz, JFrame jf) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height * 1 / 4;
		int width = screenSize.width * 1 / 4;
		setSize(new Dimension(width, height));
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("End Of The Quiz");
		lblNewLabel.setBounds(116, 11, 170, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Go Back To Home");
		lblNewLabel_1.setBounds(10, 109, 170, 33);
		getContentPane().add(lblNewLabel_1);

		JButton btnHome = new JButton("Home");
		btnHome.setBounds(203, 114, 89, 23);
		getContentPane().add(btnHome);

		btnHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				qz.returnToTitle();
			}
		});
		jf.add(contentPane);
		jf.validate();
	}
}
