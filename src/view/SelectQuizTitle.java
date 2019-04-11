package src.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.controller.QuizChecker;

/**
 * Class create drop down menu for quizzes
 *
 * @author Shashidhar Reddy Vanteru,Jiayan Wang
 * @version 1.3
 * 
 */
public class SelectQuizTitle extends JPanel{
	
	public SelectQuizTitle(QuizChecker Qc) {
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.setSize(500, 500);

		JLabel message = new JLabel("Select the quiz from choices");
		message.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(message);

		String[] choices = Qc.getQuizzes().toArray(new String[0]);

		final JComboBox<String> menu = new JComboBox<String>(choices);

		menu.setMaximumSize(menu.getPreferredSize());
		menu.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(menu);

		JButton btn = new JButton("OK");
		btn.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(btn);
    
		btn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String x = String.valueOf(menu.getSelectedItem());
				Qc.selectedTitle(x, Qc.getFolderPath());
			}
		});
	}
}