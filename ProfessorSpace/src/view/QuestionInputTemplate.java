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
import javax.swing.JTextArea;

/**
 * Form to show place to create a quiz with questions
 * @author  Yu-Ting Tsao <ytsao2@asu.edu>
 * @version 1.0
 */
public class QuestionInputTemplate extends JFrame {
	
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
	
	private JTextArea questionTextArea;
	private JTextArea optionATextArea;
	private JTextArea optionBTextArea;
	private JTextArea optionCTextArea;
	private JTextArea optionDTextArea;
	
	private static final String FRAME_TITLE = "Quiz Monster";

	public QuestionInputTemplate() {
		
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
		setupSeperator(contentPane);
	}
	
	private void setupTextArea(JPanel contentPane) {
		
		questionTextArea = new JTextArea();
		questionTextArea.setBounds(19, 84, 662, 68);
		questionTextArea.setLineWrap(true);
		contentPane.add(questionTextArea);
		
		optionATextArea = new JTextArea();
		optionATextArea.setBounds(19, 199, 662, 44);
		optionATextArea.setLineWrap(true);
		contentPane.add(optionATextArea);
		
		optionBTextArea = new JTextArea();
		optionBTextArea.setBounds(19, 294, 662, 44);
		optionBTextArea.setLineWrap(true);
		contentPane.add(optionBTextArea);
		
		optionCTextArea = new JTextArea();
		optionCTextArea.setBounds(19, 394, 662, 44);
		optionCTextArea.setLineWrap(true);
		contentPane.add(optionCTextArea);
		
		optionDTextArea = new JTextArea();
		optionDTextArea.setBounds(19, 485, 662, 44);
		optionDTextArea.setLineWrap(true);
		contentPane.add(optionDTextArea);
	}
	
	private void setupLabel(JPanel contentPane) {
		JLabel questionNumerLabel = new JLabel("Question 1.");
		questionNumerLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		questionNumerLabel.setBounds(19, 61, 678, 16);
		contentPane.add(questionNumerLabel);
		
		JLabel titleLabel = new JLabel("Fake Midterm");
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		titleLabel.setBounds(19, 6, 132, 43);
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
		optionARadioButton.setBounds(19, 164, 141, 23);
		contentPane.add(optionARadioButton);
		
		JRadioButton optionBRadioButton = new JRadioButton("B.");
		optionBRadioButton.setBounds(19, 265, 141, 23);
		contentPane.add(optionBRadioButton);
		
		JRadioButton optionCRadioButton = new JRadioButton("C.");
		optionCRadioButton.setBounds(19, 370, 141, 23);
		contentPane.add(optionCRadioButton);
		
		JRadioButton optionDRadioButton = new JRadioButton("D.");
		optionDRadioButton.setBounds(19, 460, 141, 23);
		contentPane.add(optionDRadioButton);
		
		ButtonGroup answerButtonGroup = new ButtonGroup();
		answerButtonGroup.add(optionARadioButton);
		answerButtonGroup.add(optionBRadioButton);
		answerButtonGroup.add(optionCRadioButton);
		answerButtonGroup.add(optionDRadioButton);
	} 
	
	private void setupSeperator(JPanel contentPane) {
		JSeparator seperatorAB = new JSeparator();
		seperatorAB.setBounds(6, 255, 688, 12);
		contentPane.add(seperatorAB);
		
		JSeparator separatorBC = new JSeparator();
		separatorBC.setBounds(6, 350, 688, 12);
		contentPane.add(separatorBC);
		
		JSeparator separatorCD = new JSeparator();
		separatorCD.setBounds(6, 450, 688, 12);
		contentPane.add(separatorCD);
	}
}
