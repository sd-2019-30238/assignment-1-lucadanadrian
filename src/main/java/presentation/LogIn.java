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
import java.awt.event.ContainerEvent;
import java.util.Arrays;

public class LogIn extends JFrame{
    static CreateAccount createAccount = new CreateAccount();
    static BookStore bookStore = new BookStore();
    static BookManagement bookManagement = new BookManagement();
    private JTextField emailField;
    private JPasswordField passwordField1;
    private JButton logInAsUserButton;
    private JButton logInAsStaffButton;
    private JPanel panelMain;
    private JButton createAccountButton;
    private JLabel wrongLabel;
    private JTextField staffIdField;
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Connection.class);
    UserDAO user = applicationContext.getBean("userDAO", UserDAO.class);
    StaffDAO staff = applicationContext.getBean("staffDAO", StaffDAO.class);

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
        logInAsUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goToBookStore(e);
            }
        });
        logInAsStaffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goToBookManagement(e);
            }
        });
    }

    protected void goToBookManagement(ActionEvent e){
            for(Staff s : staff.selectAll()){
                if((s.getId() == Integer.parseInt(staffIdField.getText())) && s.getEmail().equals(emailField.getText()) && Arrays.equals(s.getPassword(), passwordField1.getPassword())){
                    wrongLabel.setText("");
                    this.setVisible(false);
                    bookManagement.setVisible(true);
                }else{
                    wrongLabel.setText("*Wrong staff account*");
                }
            }
    }

    protected void goToBookStore(ActionEvent e){
        for(User u: user.selectAll()){
            if (u.getEmail().equals(emailField.getText()) && Arrays.equals(u.getPassword(),passwordField1.getPassword())){
                this.setVisible(false);
                bookStore.setVisible(true);
                bookStore.setClientEmail(emailField.getText());
            }else{
                wrongLabel.setText("*Email or Password incorrect!*");
            }
        }
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
