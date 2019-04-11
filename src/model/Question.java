package src.model;

/**
 * Class to store all the information regarding a single question.
 *
 * @author Sarthak Tiwari
 * @version 2.0
 */
public class Question {

	private String title;
	private String[] options;
	private String correctAnswer;

	/** Default Empty Constructor. */
	public Question() {
		super();
		options = new String[4];
	}

	/**
	 * Parameterized constructor with all required attributes.
	 *
	 * @param titleInput         : String with the question description
	 * @param optionsInput       : String array containing options of question
	 * @param correctOptionInput : String with the correct option
	 */
	public Question(final String titleInput, final String[] optionsInput, final String correctOptionInput) {

		options = new String[4];

		setTitle(titleInput);

		setOption1(optionsInput[0]);
		setOption2(optionsInput[1]);
		setOption3(optionsInput[2]);
		setOption4(optionsInput[3]);

		setCorrectOption(correctOptionInput);
	}

	/**
	 * @param titleInput : String with the question title
	 */
	public void setTitle(final String titleInput) {
		title = titleInput;
	}

	/**
	 * @return String : title of the question
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param option : String to be set as the option 1 of the question
	 */
	public void setOption1(final String option) {
		options[0] = option;
	}

	/**
	 * @return String : option 1 of the question
	 */
	public String getOption1() {
		return options[0];
	}

	/**
	 * @param option : String to be set as the option 2 of the question
	 */
	public void setOption2(final String option) {
		options[1] = option;
	}

	/**
	 * @return String : option 2 of the question
	 */
	public String getOption2() {
		return options[1];
	}

	/**
	 * @param option : String to be set as the option 3 of the question
	 */
	public void setOption3(final String option) {
		options[2] = option;
	}

	/**
	 * @return String : option 3 of the question
	 */
	public String getOption3() {
		return options[2];
	}

	/**
	 * @param option : String to be set as the option 4 of the question
	 */
	public void setOption4(final String option) {
		options[3] = option;
	}

	/**
	 * @return String : option 4 of the question
	 */
	public String getOption4() {
		return options[3];
	}

	/**
	 * @param correctOptionInput : String correct option of question
	 */
	public void setCorrectOption(final String correctOptionInput) {
		correctAnswer = correctOptionInput;
	}

	/**
	 * @return String : correct option of the question
	 */
	public String getCorrectOption() {
		return correctAnswer;
	}

}
