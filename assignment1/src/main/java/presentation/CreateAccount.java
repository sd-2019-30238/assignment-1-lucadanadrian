package presentation;

import bll.UserBLL;
import connection.Connection;
import model.Staff;
import model.User;

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
    private JComboBox comboBox1;
    private JTextField sumTextArea;
    UserBLL users = new UserBLL();


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
        setSize(500,400);

        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createAccount(e);
            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectPeriod(e);
            }
        });
    }
    protected void goBack(ActionEvent e){
        this.setVisible(false);
        login.setVisible(true);
    }

    protected void selectPeriod(ActionEvent e){
        System.out.println(comboBox1.getSelectedItem());
        sumTextArea.setText(8 * Integer.parseInt(String.valueOf(comboBox1.getSelectedItem().toString())) + " RON");
    }

    protected void createAccount(ActionEvent e){
        users.insertUser(new User(4,textField1.getText(),textField3.getText(),textField2.getText(),passwordField1.getPassword(),Integer.parseInt(comboBox1.getSelectedItem().toString())));
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {CreateAccount ca = new CreateAccount();
            ca.setVisible(true);});
    }
}
