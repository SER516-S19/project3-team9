package src.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import src.controller.Instructor;

/**
 * View to input a quiz title and navaigation buttion
 *
 * @author Xiangwei Zheng
 * @version 1.0
 */
public class ProfTitleView extends JPanel {

	private JLabel quizTitle;
	private JTextArea questionTextArea;

	private Instructor controller;

	public ProfTitleView(Instructor c) {
		this.controller = c;
		setBounds(350, 50, 700, 600);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setupLabel();
		setupTextArea();
		setupButton();
	}

	private void setupTextArea() {

		questionTextArea = new JTextArea();
		questionTextArea.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		questionTextArea.setBounds(19, 84, 662, 68);
		questionTextArea.setLineWrap(true);
		this.add(questionTextArea);
	}

	private void setupLabel() {

		quizTitle = new JLabel("Quiz Title");
		quizTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		quizTitle.setBounds(19, 61, 678, 16);
		this.add(quizTitle);
	}

	private void setupButton() {

		JButton gotoQuesButton = new JButton("Go To Question");
		gotoQuesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.gotoQuestion(questionTextArea.getText(), false);
			}
		});
		gotoQuesButton.setBounds(385, 543, 180, 29);
		this.add(gotoQuesButton);

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
