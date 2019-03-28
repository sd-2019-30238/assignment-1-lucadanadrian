package presentation;

import connection.Connection;
import dao.StaffDAO;
import dao.UserDAO;
import model.Staff;
import model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
        ApplicationContext applicationContext= new AnnotationConfigApplicationContext(Connection.class);
//        UserDAO users = applicationContext.getBean("userDAO", UserDAO.class);
        StaffDAO staff = applicationContext.getBean("staffDAO", StaffDAO.class);

//        users.insertTable(new User(4,textField1.getText(),textField3.getText(),textField2.getText(),passwordField1.getPassword(),Integer.parseInt(comboBox1.getSelectedItem().toString())));
//        staff.insertStaff(new Staff(1,textField1.getText(),passwordField1.getPassword()));
        //        System.out.println(textField1.getText());
//        System.out.println(passwordField1.getPassword());
//        System.out.println(textField2.getText());
//        System.out.println(textField3.getText());
//          this.setVisible(false);
//        System.out.println(Integer.parseInt(comboBox1.getSelectedItem().toString()));

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {CreateAccount ca = new CreateAccount();
            ca.setVisible(true);});
    }
}
