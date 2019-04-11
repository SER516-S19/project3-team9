package src.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import src.controller.Instructor;

/**
 * Landing view to create a quiz
 *
 * @author Aditya Vikram
 * @version 1.0
 */
public class ProfLandingView extends JPanel {

	private JLabel quizTitle;

	private Instructor controller;

	public ProfLandingView(Instructor c) {
		this.controller = c;
		setBounds(350, 50, 700, 600);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setupLabel();
		setupButton();
	}

	private void setupLabel() {

		quizTitle = new JLabel("Welcome Professor");
		quizTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		quizTitle.setBounds(19, 61, 678, 16);
		this.add(quizTitle);
	}

	private void setupButton() {

		JButton createQuizButton = new JButton("Create Quiz");
		createQuizButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.editTitlePage();
			}
		});
		createQuizButton.setBounds(385, 543, 180, 29);
		this.add(createQuizButton);

		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.exitQuiz(true);
			}
		});
		exitButton.setBounds(577, 543, 117, 29);
		this.add(exitButton);
	}
}
