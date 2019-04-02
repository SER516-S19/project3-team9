package src.model;
/**
 * Class to store all the information regarding a single question.
 *
 * @author Sarthak Tiwari
 * @version 1.0
 */
public class Question {

    private String description;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private short correctOption;

    /** Default Empty Constructor. */
    public Question() {
        super();
    }

    /**
     * Parametrised constructor with all required attributes.
     *
     * @param descriptionInput    : String with the question description
     * @param option1Input        : String with the option 1 of the question
     * @param option2Input        : String with the option 2 of the question
     * @param option3Input        : String with the option 3 of the question
     * @param option4Input        : String with the option 4 of the question
     * @param correctOptionNumberInput : Short giving the correct options number
     */
    public Question(final String descriptionInput,
        final String option1Input, final String option2Input,
        final String option3Input, final String option4Input,
        final short correctOptionNumberInput) {

        setDescription(descriptionInput);

        setOption1(option1Input);
        setOption2(option2Input);
        setOption3(option3Input);
        setOption4(option4Input);

        setCorrectOption(correctOptionNumberInput);
    }

    /**
     * @param descriptionInput : String with the question description
     */
    public void setDescription(final String descriptionInput) {
        this.description = descriptionInput;
    }

    /**
     * @return String : description of the question
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param option : String to be set as the option 1 of the question
     */
    public void setOption1(final String option) {
        this.option1 = option;
    }

    /**
     * @return String : option 1 of the question
     */
    public String getOption1() {
        return option1;
    }

    /**
     * @param option : String to be set as the option 2 of the question
     */
    public void setOption2(final String option) {
        this.option2 = option;
    }

    /**
     * @return String : option 2 of the question
     */
    public String getOption2() {
        return option2;
    }

    /**
     * @param option : String to be set as the option 3 of the question
     */
    public void setOption3(final String option) {
        this.option3 = option;
    }

    /**
     * @return String : option 3 of the question
     */
    public String getOption3() {
        return option3;
    }

    /**
     * @param option : String to be set as the option 4 of the question
     */
    public void setOption4(final String option) {
        this.option4 = option;
    }

    /**
     * @return String : option 4 of the question
     */
    public String getOption4() {
        return option4;
    }

    /**
     * @param optionNumber : Short option number of correct options
     */
    public void setCorrectOption(final short optionNumber) {
        this.correctOption = optionNumber;
    }

    /**
     * @return short : option number of the correct option
     */
    public short getCorrectOption() {
        return correctOption;
    }

}
