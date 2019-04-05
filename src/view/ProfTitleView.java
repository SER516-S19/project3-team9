import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
/**
 * Form to input a quiz title and navaigation buttion
 *
 * @author Xiangwei Zheng
 * @version 1.0
 */
public class ProfTitleView extends JFrame{
    private JTextField titleTextField;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ProfTitleView frame = new ProfTitleView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public ProfTitleView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(350, 50, 700, 600);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        setupLabel(contentPane);
        contentPane.setLayout(null);

        setupTextField(contentPane);
    }
    private void setupTextField(JPanel contentPane) {
        titleTextField = new JTextField();
        titleTextField.setBounds(6, 49, 688, 37);
        contentPane.add(titleTextField);
        titleTextField.setColumns(10);
    }
    private void setupLabel(JPanel contentPane) {
        JLabel titleLabel = new JLabel("Quiz Title");
        titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        titleLabel.setBounds(6, 6, 132, 43);
        contentPane.add(titleLabel);
    }
}
