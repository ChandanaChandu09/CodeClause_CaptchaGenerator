import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class captcha extends JFrame {

    private JLabel captchaLabel;
    private JTextField captchaTextField;
    private JButton generateButton;
    private String generatedCaptcha;

    public String generateCaptcha() {
        //captcha generation using random
        String captchachar = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder captcha = new StringBuilder();
        Random random = new Random();

        //length of the captcha is 6
        for (int i = 0; i < 6; i++)
        {
            char c = captchachar.charAt(random.nextInt(captchachar.length()));
            captcha.append(c);
        }
        return captcha.toString();
    }

    public captcha() {
        setTitle("Captcha Generator");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        captchaLabel = new JLabel();
        captchaLabel.setFont(new Font("Arial", Font.BOLD, 24));
        captchaLabel.setForeground(Color.BLUE);
        captchaTextField = new JTextField(10);
        generateButton = new JButton("Generate Captcha");
        generateButton.setForeground(Color.BLACK);
        generateButton.setFont(new Font("Arial", Font.BOLD, 24));

        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                generatedCaptcha = generateCaptcha();
                captchaLabel.setText(generatedCaptcha);
            }
        });

        JButton SubmitButton = new JButton("Submit");
        SubmitButton.setForeground(Color.RED);
        SubmitButton.setFont(new Font("Arial", Font.BOLD, 24));
        SubmitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(captchaTextField.getText().equals(generatedCaptcha))
                {
                    JOptionPane.showMessageDialog(null, "Captcha entered correctly");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Incorrect CAPTCHA. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                    // Clearing the text field
                    captchaTextField.setText("");
                    // Regeneration of a new CAPTCHA
                    generatedCaptcha = generateCaptcha();
                }
            }
        });

        JPanel captchapanel = new JPanel();
        captchapanel.add(captchaLabel);
        captchapanel.add(captchaTextField);
        captchapanel.add(generateButton);
        captchapanel.add(SubmitButton);

        add(captchapanel);
    }

    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new captcha().setVisible(true);
            }
        });
    }
}
