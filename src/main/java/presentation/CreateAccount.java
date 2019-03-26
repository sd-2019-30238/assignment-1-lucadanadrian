package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateAccount extends JFrame{
    static LogIn login = new LogIn();
    private JPanel mainPanel;
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton createAccountButton;
    private JButton backToLogInButton;

    public CreateAccount() {
        backToLogInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                goBack(e);
            }
        });
        setTitle("LogIn");
        setContentPane(mainPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setSize(300,400);

    }
    protected void goBack(ActionEvent e){
        this.setVisible(false);
        login.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {CreateAccount ca = new CreateAccount();
            ca.setVisible(true);});
    }
}
