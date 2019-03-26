package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogIn extends JFrame{
    static CreateAccount createAccount = new CreateAccount();
    private JTextField textField3;
    private JPasswordField passwordField1;
    private JButton logInButton;
    private JButton logInAsStaffButton;
    private JPanel panelMain;
    private JButton createAccountButton;

    public LogIn(){
//        JFrame frame = new JFrame("LogIn");
//        setContentPane(new LogIn().panelMain);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        pack();
//        setSize(300,400);
//        setVisible(true);
        setTitle("LogIn");
        setContentPane(panelMain);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setSize(300,400);

        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goToCreateAccount(e);
            }
        });
    }

    protected void goToCreateAccount(ActionEvent e) {
        this.setVisible(false);
        createAccount.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {LogIn li = new LogIn();
        li.setVisible(true);});
    }
}
