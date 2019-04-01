import javax.swing.JFrame;

/**
 * Form to show a question and navaigation buttion and to give user
 * functionality to select one of the options.
 * @author      Sarthak Tiwari <sarthak.tiwari@asu.edu>
 * @version     1.0
 */
public class TestRunner {

    public static void main(String[] args) {

        JFrame f = new JFrame();

        f.setSize(500, 500);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        int flag = QuestionAttemptTemplate.showQuestion(f, new QuestionStub());
        if(flag == QuestionAttemptTemplate.CORRECT_ANSWER)
            System.out.println("Correct Answer !");
        else if(flag == QuestionAttemptTemplate.INCORRECT_ANSWER)
            System.out.println("Incorrect Answer !");
        else if(flag == QuestionAttemptTemplate.GAVE_UP){
            System.out.println("Student Gave Up !");
        }
    }
}