package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;

/**
 * Form to show place to create a quiz with questions
 * @author  Yu-Ting Tsao <ytsao2@asu.edu>
 * @version 1.0
 */
public class QuestionInputTemplate extends JFrame {
	
	private JTextField quiztitleTextField;
	private JTextField titleTextField;
	private JTextField optionATextField;
	private JTextField optionBTextField;
	private JTextField optionCTextField;
	private JTextField optionDTextField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuestionInputTemplate frame = new QuestionInputTemplate();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public QuestionInputTemplate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 50, 700, 600);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setupTextField(contentPane);
		setupLabel(contentPane);
		setupButton(contentPane);
		setupSeperator(contentPane);
	}
	
	private void setupTextField(JPanel contentPane) {
		titleTextField = new JTextField();
		titleTextField.setBounds(6, 49, 688, 37);
		contentPane.add(titleTextField);
		titleTextField.setColumns(10);
		
		optionATextField = new JTextField();
		optionATextField.setBounds(19, 164, 662, 57);
		contentPane.add(optionATextField);
		optionATextField.setColumns(10);
		
		optionBTextField = new JTextField();
		optionBTextField.setColumns(10);
		optionBTextField.setBounds(19, 268, 662, 51);
		contentPane.add(optionBTextField);
		
		optionCTextField = new JTextField();
		optionCTextField.setColumns(10);
		optionCTextField.setBounds(19, 366, 662, 51);
		contentPane.add(optionCTextField);
		
		optionDTextField = new JTextField();
		optionDTextField.setColumns(10);
		optionDTextField.setBounds(19, 467, 662, 51);
		contentPane.add(optionDTextField);
		
		
	}
	
	private void setupLabel(JPanel contentPane) {
		JLabel questionNumerLabel = new JLabel("Question 1.");
		questionNumerLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		questionNumerLabel.setBounds(16, 98, 678, 16);
		contentPane.add(questionNumerLabel);
		
		JLabel titleLabel = new JLabel("Quiz Title");
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		titleLabel.setBounds(6, 6, 132, 43);
		contentPane.add(titleLabel);
	} 
	
	private void setupButton(JPanel contentPane) {
		JButton createButton = new JButton("Create");
		createButton.setBounds(577, 543, 117, 29);
		contentPane.add(createButton);
		
		JButton addMoreButton = new JButton("Add More Question");
		addMoreButton.setBounds(385, 543, 180, 29);
		contentPane.add(addMoreButton);
		
		JRadioButton optionARadioButton = new JRadioButton("A.");
		optionARadioButton.setSelected(true);
		optionARadioButton.setBounds(19, 139, 141, 23);
		contentPane.add(optionARadioButton);
		
		JRadioButton optionBRadioButton = new JRadioButton("B.");
		optionBRadioButton.setBounds(19, 248, 141, 23);
		contentPane.add(optionBRadioButton);
		
		JRadioButton optionCRadioButton = new JRadioButton("C.");
		optionCRadioButton.setBounds(19, 343, 141, 23);
		contentPane.add(optionCRadioButton);
		
		JRadioButton optionDRadioButton = new JRadioButton("D.");
		optionDRadioButton.setBounds(19, 443, 141, 23);
		contentPane.add(optionDRadioButton);
		
		ButtonGroup answerButtonGroup = new ButtonGroup();
		answerButtonGroup.add(optionARadioButton);
		answerButtonGroup.add(optionBRadioButton);
		answerButtonGroup.add(optionCRadioButton);
		answerButtonGroup.add(optionDRadioButton);
	} 
	
	private void setupSeperator(JPanel contentPane) {
		JSeparator seperatorAB = new JSeparator();
		seperatorAB.setBounds(6, 224, 688, 12);
		contentPane.add(seperatorAB);
		
		JSeparator separatorBC = new JSeparator();
		separatorBC.setBounds(6, 331, 688, 12);
		contentPane.add(separatorBC);
		
		JSeparator separatorCD = new JSeparator();
		separatorCD.setBounds(6, 431, 688, 12);
		contentPane.add(separatorCD);
	}
}
