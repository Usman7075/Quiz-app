import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {
    private JLabel[] questionLabels;
    private JRadioButton[][] optionButtons;
    private JButton submitButton;
    private int totalQuestions = 10;

    public Main() {
        setTitle("Computer Science Quiz");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(totalQuestions + 1, 1));

        questionLabels = new JLabel[totalQuestions];
        optionButtons = new JRadioButton[totalQuestions][3];

        // Questions and options
        String[] questions = {
                "Which programming language is known as the 'mother of all languages'?",
                "What is the output of the following Java code? \n\n public class Main {\n  public static void main(String[] args) {\n   System.out.println(2 + 3 + \"4\");\n  }\n }",
                "What does HTML stand for?",
                "What is the purpose of CSS?",
                "What does SQL stand for?",
                "What is the most commonly used language for web development?",
                "What is the name of the protocol that is used to transfer web pages over the internet?",
                "Which company developed the Java programming language?",
                "Which data structure operates on a last-in, first-out (LIFO) basis?",
                "What is the purpose of a constructor in Java classes?"
        };

        String[][] options = {
                {"Java", "C", "Assembly"},
                {"54", "234", "5"},
                {"Hyper Text Markup Language", "Hyperlinks and Text Markup Language", "Home Tool Markup Language"},
                {"To style web pages", "To define the structure of web pages", "To add interactivity to web pages"},
                {"Structured Query Language", "Simple Query Language", "Sequential Query Language"},
                {"JavaScript", "Python", "Java"},
                {"HTTP", "FTP", "TCP/IP"},
                {"Oracle", "Microsoft", "Sun Microsystems"},
                {"Stack", "Queue", "Array"},
                {"To initialize object properties", "To define methods", "To manage memory allocation"}
        };

        for (int i = 0; i < totalQuestions; i++) {
            questionLabels[i] = new JLabel("Question " + (i + 1) + ": " + questions[i]);
            add(questionLabels[i]);

            ButtonGroup buttonGroup = new ButtonGroup();
            for (int j = 0; j < 3; j++) {
                optionButtons[i][j] = new JRadioButton();
                optionButtons[i][j].setText(options[i][j]);
                buttonGroup.add(optionButtons[i][j]);
                add(optionButtons[i][j]);
            }
        }

        // Submit button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int score = calculateScore();
                JOptionPane.showMessageDialog(Main.this, "Your score: " + score + " out of " + totalQuestions);
            }
        });
        add(submitButton);

        setVisible(true);
    }

    // Calculate the score based on selected options
    private int calculateScore() {
        int score = 0;
        for (int i = 0; i < totalQuestions; i++) {
            for (int j = 0; j < 3; j++) {
                if (optionButtons[i][j].isSelected() && i == j) {
                    score++;
                }
            }
        }
        return score;
    }
}

