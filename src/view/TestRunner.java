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
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        QuestionAttemptTemplate q = new QuestionAttemptTemplate(f);
        if(q.showQuestion(new QuestionStub())){
            System.out.println("Correct Answer !");
        }
        else
            System.out.println("Wrong Answer !");
    }

}