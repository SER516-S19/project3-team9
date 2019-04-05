package view;
package src.controller;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectQuizTitle {

	SelectQuizTitle(JFrame quiz) {
		JPanel quizpanel = new JPanel();
		quizpanel.setLayout(new BoxLayout(quizpanel, BoxLayout.Y_AXIS));

		quiz.add(quizpanel);

		JLabel message = new JLabel("Select the quiz from choices");
		message.setAlignmentX(Component.CENTER_ALIGNMENT);

		quizpanel.add(message);

		String[] choices = { "CHOICE 1", "CHOICE 2", "CHOICE 3", "CHOICE 4", "CHOICE 5", "CHOICE 6" };

		final JComboBox<String> menu = new JComboBox<String>(choices);

		menu.setMaximumSize(menu.getPreferredSize());
		menu.setAlignmentX(Component.CENTER_ALIGNMENT);
		quizpanel.add(menu);

		JButton btn = new JButton("OK");
		btn.setAlignmentX(Component.CENTER_ALIGNMENT);
		quizpanel.add(btn);

		menu.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				QuizChecker Qc = new QuizChecker();
				String x = String.valueOf(menu.getSelectedItem());
				Qc.selectedTitle(x);

			}
		});

	}
}