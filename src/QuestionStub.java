public class QuestionStub {

    private String description = "Some question title that defines this question and some other blah blah blah text....\n It can be multiline so this is a new line\n And this is another new line";
    public String option1 = "First Option for this question which is too long... it is still going on... and still you are reading it.... because it is not wrapped\nOh more text is here....";
    public String option2 = "Short Option";
    public String option3 = "3";
    public String option4 = "Blah Blah Blah Blah Blah Blah";
    public short correctOption = 2;

    
    public String getDescription() {
        return description;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public short getCorrectOption() {
        return correctOption;
    }

}