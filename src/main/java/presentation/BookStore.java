package presentation;

import connection.Connection;
import dao.BookDAO;
import model.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookStore extends JFrame{
    static LogIn logIn = new LogIn();
    private JButton displayBooksButton;
    private JButton logOutButton;
    private JPanel mainPanel;
    private JTextArea textArea1;
    ApplicationContext appContext = new AnnotationConfigApplicationContext(Connection.class);
    BookDAO book = appContext.getBean("bookDAO",BookDAO.class);

    public BookStore() {
        setTitle("LogIn");
        setContentPane(mainPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setSize(750,400);
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logOut(e);
            }
        });

        displayBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showBooks(e);
            }
        });

    }
    protected void showBooks(ActionEvent e) {
//        System.out.println(book.selectAll());
        textArea1.setText(book.selectAll().toString());
    }

    protected void logOut(ActionEvent e) {
        this.setVisible(false);
        logIn.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {BookStore bs= new BookStore();
            bs.setVisible(true);});
    }
}
