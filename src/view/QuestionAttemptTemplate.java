import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

/**
 * Form to show a question and navaigation buttion and to give user
 * functionality to select one of the options.
 *
 * @author Sarthak Tiwari
 * @version 1.0
 */
public final class QuestionAttemptTemplate extends JDialog {

    private static QuestionAttemptTemplate instance = null;

    private static JLabel questionDescription;

    private static JRadioButton option1;
    private static JRadioButton option2;
    private static JRadioButton option3;
    private static JRadioButton option4;
    private static ButtonGroup options;

    private static JButton next;
    private static JButton giveup;

    private static short correctAnswer = 0;
    private static int responseStatus;

    public static final int CORRECT_ANSWER = 0;
    public static final int INCORRECT_ANSWER = 1;
    public static final int GAVE_UP = -1;

    /**
     * public method to show the view.
     *
     * @param frame    : JFrame representing the parent frame
     * @param question : QuestionStub representing the question to be displayed
     * @return int : one of the three values representing student gave correct
     *         answer, incorrect answer or gave up
     */
    public static int showQuestion(final JFrame frame,
                                    final QuestionStub question) {

        if (instance == null) {
            instance = new QuestionAttemptTemplate(frame);
        }

        questionDescription.setText(
                    convertToMultiline(question.getDescription()));
        option1.setText(convertToMultiline(question.getOption1()));
        option2.setText(convertToMultiline(question.getOption2()));
        option3.setText(convertToMultiline(question.getOption3()));
        option4.setText(convertToMultiline(question.getOption4()));

        correctAnswer = question.getCorrectOption();

        instance.pack();
        instance.setVisible(true);
        return responseStatus;
    }

    /**
     * Overload of the showQuestion method to include last question parameter
     *
     * @param frame    : JFrame representing the parent frame
     * @param question : QuestionStub representing the question to be displayed
     * @param isLastQuestion : boolean indicating whether displayed question
     * is last question
     * @return int : one of the three values representing student gave correct
     *         answer, incorrect answer or gave up
     */
    public static int showQuestion(final JFrame frame,
                                    final QuestionStub question,
                                    final boolean isLastQuestion) {

        if (instance == null) {
            instance = new QuestionAttemptTemplate(frame);
        }
        
        if(isLastQuestion) {
            next.setText("Submit");
        }

        return showQuestion(frame, question);
    }

    /**
     * Constructor to setup the main window.
     *
     * @param frame : JFrame representing the parent frame
     */
    private QuestionAttemptTemplate(final JFrame frame) {

        super(frame, true);

        setTitle("Question");

        responseStatus = INCORRECT_ANSWER;

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        this.setSize(600, 400);
        this.setMinimumSize(this.getSize());
        this.setMaximumSize(this.getSize());

        JPanel mainPanel = setupPanel();
        mainPanel.setBorder(new EmptyBorder(10, 10, 5, 5));

        this.getContentPane().add(mainPanel, BorderLayout.CENTER);
        setResizable(false);
        setLocationRelativeTo(frame);
    }

    /**
     * Method to setup the main UI panel.
     *
     * @return JPanel : Panel containing all the UI components
     */
    private JPanel setupPanel() {

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new Insets(0, 0, 10, 10);
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.weightx = 1;

        mainPanel.setMinimumSize(new Dimension(400, 600));

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        questionDescription = new JLabel("");

        mainPanel.add(questionDescription, gridBagConstraints);

        options = new ButtonGroup();

        JPanel optionsPane = setupRadios();

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        mainPanel.add(optionsPane, gridBagConstraints);

        JPanel buttonPane = setupButtons();

        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        mainPanel.add(buttonPane, gridBagConstraints);

        return mainPanel;
    }

    /**
     * This method adds radio buttons to the UI.
     *
     * @return JPanel : panel containing all the radio buttons
     */
    private JPanel setupRadios() {

        JPanel optionsPane = new JPanel();
        optionsPane.setOpaque(false);
        optionsPane.setLayout(new GridBagLayout());
        optionsPane.setBorder(BorderFactory.createTitledBorder(
                            BorderFactory.createEtchedBorder(), "Options"));

        option1 = new JRadioButton("");
        options.add(option1);
        option2 = new JRadioButton("");
        options.add(option2);
        option3 = new JRadioButton("");
        options.add(option3);
        option4 = new JRadioButton("");
        options.add(option4);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0.25;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.LINE_START;
        optionsPane.add(option1, gbc);
        gbc.gridy++;
        optionsPane.add(option2, gbc);
        gbc.gridy++;
        optionsPane.add(option3, gbc);
        gbc.gridy++;
        optionsPane.add(option4, gbc);

        return optionsPane;

    }

    /**
     * This method adds event listeners to both the buttons.
     *
     * @return JPanel : panel containing the next and giveup button
     */
    private JPanel setupButtons() {

        JPanel buttonPane = new JPanel(new GridLayout(1, 2, 15, 15));

        next = new JButton("Next");
        giveup = new JButton("Give Up !");

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                responseStatus = INCORRECT_ANSWER;
                switch (correctAnswer) {
                case 0:
                    if (option1.isSelected()) {
                        responseStatus = CORRECT_ANSWER;
                    }
                    break;
                case 1:
                    if (option2.isSelected()) {
                        responseStatus = CORRECT_ANSWER;
                    }
                    break;
                case 2:
                    if (option3.isSelected()) {
                        responseStatus = CORRECT_ANSWER;
                    }
                    break;
                case 3:
                    if (option4.isSelected()) {
                        responseStatus = CORRECT_ANSWER;
                    }
                    break;
                default:
                    responseStatus = INCORRECT_ANSWER;
                }
                clearAndHide();
            }
        });

        giveup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                responseStatus = GAVE_UP;
                clearAndHide();
            }
        });

        buttonPane.add(next);
        buttonPane.add(giveup);

        return buttonPane;
    }

    /** This method clears the dialog and hides it. */
    public void clearAndHide() {
        options.clearSelection();
        next.setText("Next");
        setVisible(false);
    }

    private static String convertToMultiline(final String orig) {
        return "<html>" + orig.replaceAll("\n", "<br>");
    }
}
