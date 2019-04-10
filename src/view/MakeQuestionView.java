package src.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

import src.controller.Instructor;
import src.model.Question;

/**
 * View for professor to create a question and its options.
 *
 * @author Yu-Ting Tsao, Aditya Vikram
 * @version 1.1
 */
public class MakeQuestionView extends JPanel {
	
	private JLabel questionNumerLabel;
	private JTextArea questionTextArea;
	private ArrayList<JTextArea> optionTextAreas;
	private ButtonGroup answerButtonGroup;
	private AbstractButton optionARadioButton;
	private String title;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private Instructor controller;
	
	public MakeQuestionView(String title, Instructor c) {
		
		this.controller = c;
		this.setLayout(null);
		this.setTitle(title);
		setupTextArea();
		setupLabel(title);
		setupButton();
		setupSeperator();
	}
	
	public void refreshPage(int questionNo) {
		questionNumerLabel.setText("Question " + questionNo  + ".");
		questionTextArea.setText(null);
		for(JTextArea option: optionTextAreas){
			option.setText(null);
		}
		optionARadioButton.setSelected(true);
	}
	
	private Question formCurrentQuestion() {
		
		Question q = null;
		
		Enumeration<AbstractButton> elements = answerButtonGroup.getElements();
		for(int i = 0; i<answerButtonGroup.getButtonCount(); i++) {
			AbstractButton button = (AbstractButton)elements.nextElement();
			if (button.isSelected() == true) {
				String[] options = new String[4];
				options[0] = optionTextAreas.get(0).getText();
				options[1] = optionTextAreas.get(1).getText();
				options[2] = optionTextAreas.get(2).getText();
				options[3] = optionTextAreas.get(3).getText();
				
				q = new Question(questionTextArea.getText(),
						options,
						optionTextAreas.get(i).getText());
			}
		}
		return q;
	}
	
	private void setupTextArea() {
		
		optionTextAreas = new ArrayList<JTextArea>();
		
		questionTextArea = new JTextArea();
		questionTextArea.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		questionTextArea.setBounds(19, 84, 662, 68);
		questionTextArea.setLineWrap(true);
		add(questionTextArea);
		
		JTextArea optionATextArea = new JTextArea();
		optionATextArea.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		optionATextArea.setBounds(19, 199, 662, 44);
		optionATextArea.setLineWrap(true);
		add(optionATextArea);
		optionTextAreas.add(optionATextArea);
		
		JTextArea optionBTextArea = new JTextArea();
		optionBTextArea.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		optionBTextArea.setBounds(19, 294, 662, 44);
		optionBTextArea.setLineWrap(true);
		add(optionBTextArea);
		optionTextAreas.add(optionBTextArea);
		
		JTextArea optionCTextArea = new JTextArea();
		optionCTextArea.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		optionCTextArea.setBounds(19, 394, 662, 44);
		optionCTextArea.setLineWrap(true);
		add(optionCTextArea);
		optionTextAreas.add(optionCTextArea);
		
		JTextArea optionDTextArea = new JTextArea();
		optionDTextArea.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		optionDTextArea.setBounds(19, 485, 662, 44);
		optionDTextArea.setLineWrap(true);
		add(optionDTextArea);
		optionTextAreas.add(optionDTextArea);
	}
	
	private void setupLabel(String title) {
		
		questionNumerLabel = new JLabel("Question 1.");
		questionNumerLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		questionNumerLabel.setBounds(19, 61, 678, 16);
		add(questionNumerLabel);
		
		JLabel titleLabel = new JLabel(title);
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		titleLabel.setBounds(19, 6, 662, 43);
		add(titleLabel);
	} 
	
	private void setupButton() {
		
		JButton addMoreButton = new JButton("Add More Question");
		addMoreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.storeQuestion(formCurrentQuestion(), false);
			}
		});
		addMoreButton.setBounds(385, 543, 180, 29);
		add(addMoreButton);
		
		JButton createButton = new JButton("Create");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.storeQuestion(formCurrentQuestion(), true);
			}
		});
		createButton.setBounds(577, 543, 117, 29);
		add(createButton);
		
		JButton exitButton = new JButton("EXIT");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.exitQuiz(true);
			}
		});
		exitButton.setBounds(19, 541, 117, 29);
		add(exitButton);
		
		optionARadioButton = new JRadioButton("A.");
		optionARadioButton.setSelected(true);
		optionARadioButton.setBounds(19, 164, 141, 23);
		add(optionARadioButton);
		
		AbstractButton optionBRadioButton = new JRadioButton("B.");
		optionBRadioButton.setBounds(19, 265, 141, 23);
		add(optionBRadioButton);
		
		AbstractButton optionCRadioButton = new JRadioButton("C.");
		optionCRadioButton.setBounds(19, 370, 141, 23);
		add(optionCRadioButton);
		
		AbstractButton optionDRadioButton = new JRadioButton("D.");
		optionDRadioButton.setBounds(19, 460, 141, 23);
		add(optionDRadioButton);
		
		answerButtonGroup = new ButtonGroup();
		answerButtonGroup.add(optionARadioButton);
		answerButtonGroup.add(optionBRadioButton);
		answerButtonGroup.add(optionCRadioButton);
		answerButtonGroup.add(optionDRadioButton);
	} 
	
	private void setupSeperator() {
		
		JSeparator seperatorAB = new JSeparator();
		seperatorAB.setBounds(6, 255, 688, 12);
		add(seperatorAB);
		
		JSeparator separatorBC = new JSeparator();
		separatorBC.setBounds(6, 350, 688, 12);
		add(separatorBC);
		
		JSeparator separatorCD = new JSeparator();
		separatorCD.setBounds(6, 450, 688, 12);
		add(separatorCD);
	}

	public void navigatePage() {
		
		this.setVisible(false);
		controller.landingPage();	
	}
}
