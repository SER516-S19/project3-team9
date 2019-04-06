package src.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
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
public class ProfTitleView extends JFrame {

	private static final String FRAME_TITLE = "Quiz Monster";
	
	private JLabel quizTitle;
	private JTextArea questionTextArea;
		
	
	private Instructor controller;
	
	public ProfTitleView(Instructor c) {		
		this.controller = c;		
		this.setTitle(FRAME_TITLE);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 50, 700, 600);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);		
		setupTextArea(contentPane);
		setupLabel(contentPane);
		setupButton(contentPane);		
	}
	
	
	

	
	private void setupTextArea(JPanel contentPane) {
		
		questionTextArea = new JTextArea();
		questionTextArea.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		questionTextArea.setBounds(19, 84, 662, 68);
		questionTextArea.setLineWrap(true);
		contentPane.add(questionTextArea);
		
		
	}
	
	private void setupLabel(JPanel contentPane) {
		
		quizTitle = new JLabel("Quiz Title");
		quizTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		quizTitle.setBounds(19, 61, 678, 16);
		contentPane.add(quizTitle);
		
		JLabel titleLabel = new JLabel("Pleae Enter Quiz Title Below");
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		titleLabel.setBounds(19, 6, 662, 43);
		contentPane.add(titleLabel);
	} 
	
	private void setupButton(JPanel contentPane) {
		
		JButton gotoQuesButton = new JButton("Go To Question");
		gotoQuesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.gotoQuestion(quizTitle.getText(), false);
			}
		});
		gotoQuesButton.setBounds(385, 543, 180, 29);
		contentPane.add(gotoQuesButton);
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//controller.exit(true);
			}
		});
		exitButton.setBounds(577, 543, 117, 29);
		contentPane.add(exitButton);
		
		
		

	} 
	
	
}
