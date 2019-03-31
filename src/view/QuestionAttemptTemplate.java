import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * Form to show a question and navaigation buttion and to give user
 * functionality to select one of the options.
 * @author      Sarthak Tiwari <sarthak.tiwari@asu.edu>
 * @version     1.0
 */
public class QuestionAttemptTemplate extends JDialog {

    private JLabel questionDescription;
    private JRadioButton option1;
    private JRadioButton option2;
    private JRadioButton option3;
    private JRadioButton option4;
    private ButtonGroup options;

    private short correctAnswer = 0;
    private boolean isCorrectAnswer = false;

    private static String convertToMultiline(String orig)
    {
        return "<html>" + orig.replaceAll("\n", "<br>");
    }

    public boolean showQuestion(QuestionStub question) {

        questionDescription.setText(convertToMultiline(question.getDescription()));
        option1.setText(convertToMultiline(question.getOption1()));
        option2.setText(convertToMultiline(question.getOption2()));
        option3.setText(convertToMultiline(question.getOption3()));
        option4.setText(convertToMultiline(question.getOption4()));

        correctAnswer = question.getCorrectOption();

        this.pack();
        setVisible(true);
        return isCorrectAnswer;
    }

    public QuestionAttemptTemplate(JFrame frame) {

        super(frame, true);

        setTitle("Question");

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override public void windowClosing(WindowEvent we) {
                    isCorrectAnswer = false;
                    clearAndHide();
            }
        });

        this.setSize(600,400);
        this.setMinimumSize(this.getSize());
        this.setMaximumSize(this.getSize());

        JPanel mainPanel = setupPanel();
        mainPanel.setBorder(new EmptyBorder(10, 10, 5, 5 ));

        this.getContentPane().add(mainPanel, BorderLayout.CENTER);
        setResizable(false);
    }

    private JPanel setupPanel(){

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new Insets(0,0,10,10);
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.weightx = 1;

        mainPanel.setMinimumSize(new Dimension(400, 600));

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        questionDescription = new JLabel("");
        
        mainPanel.add(questionDescription, gridBagConstraints);

        options = new ButtonGroup();

        JPanel optionsPane = new JPanel();
        optionsPane.setOpaque(false);
        optionsPane.setLayout(new GridBagLayout());
        optionsPane.setBorder(BorderFactory.createTitledBorder(
                   BorderFactory.createEtchedBorder(), "Options"));
        
        option1 = new JRadioButton(""); options.add(option1);
        option2 = new JRadioButton(""); options.add(option2);
        option3 = new JRadioButton(""); options.add(option3);
        option4 = new JRadioButton(""); options.add(option4);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;  gbc.gridy = 0;
        gbc.weightx = 1;    gbc.weighty = 0.25;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.LINE_START;
        optionsPane.add(option1, gbc);  gbc.gridy++;
        optionsPane.add(option2, gbc);  gbc.gridy++;
        optionsPane.add(option3, gbc);  gbc.gridy++;
        optionsPane.add(option4, gbc);

        gridBagConstraints.fill = GridBagConstraints.NONE;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        mainPanel.add(optionsPane, gridBagConstraints);
        
        JButton btn = new JButton("Next");
        btn.addActionListener(new ActionListener(){
            @Override public void actionPerformed(ActionEvent e) {
                isCorrectAnswer = false;
                switch(correctAnswer){
                    case 0:
                        if(option1.isSelected())
                            isCorrectAnswer = true;
                        break;
                    case 1:
                        if(option2.isSelected())
                            isCorrectAnswer = true;
                        break;
                    case 2:
                        if(option3.isSelected())
                            isCorrectAnswer = true;
                        break;
                    case 3:
                        if(option4.isSelected())
                            isCorrectAnswer = true;
                        break;
                }
                clearAndHide();
            }
        });

        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = GridBagConstraints.NONE;
        gridBagConstraints.anchor = GridBagConstraints.PAGE_END;
        mainPanel.add(btn, gridBagConstraints);

        return mainPanel;
    }

    /** This method clears the dialog and hides it. */
    public void clearAndHide() {
        options.clearSelection();
        setVisible(false);
    }


}