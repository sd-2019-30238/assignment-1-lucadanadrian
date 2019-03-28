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

public class BookStore extends JFrame {
    static LogIn logIn = new LogIn();
    private JButton displayBooksButton;
    private JButton logOutButton;
    private JPanel mainPanel;
    private JTextArea textArea1;
    private JButton lendButton;
    private JTextField lendBookField;
    private JTextField returnBookField;
    private JButton returnButton;
    private JLabel actionMessage;
    ApplicationContext appContext = new AnnotationConfigApplicationContext(Connection.class);
    BookDAO book = appContext.getBean("bookDAO", BookDAO.class);

    public BookStore() {
        setTitle("LogIn");
        setContentPane(mainPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setSize(850, 400);
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

        lendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Book lentBook = book.selectById(Integer.parseInt(lendBookField.getText()));

                if (book.selectById(Integer.parseInt(lendBookField.getText())).getNumberOfBooks() > 0) {
                    int oldNrOfBooks = book.selectById(Integer.parseInt(lendBookField.getText())).getNumberOfBooks();
                    book.updateTable(new Book(lentBook.getId(),
                            lentBook.getTitle(),
                            lentBook.getAuthor(),
                            lentBook.getGenre(),
                            lentBook.getReleaseDate(),
                            lentBook.getPrice(),
                            oldNrOfBooks - 1)
                    );
                    actionMessage.setText("Yout lent the book " + lentBook.getTitle());
                } else {
                    actionMessage.setText("The book is no longer available");
                }


            }
        });
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Book lentBook = book.selectById(Integer.parseInt(returnBookField.getText()));

                int oldNrOfBooks = book.selectById(Integer.parseInt(returnBookField.getText())).getNumberOfBooks();
                book.updateTable(new Book(lentBook.getId(),
                        lentBook.getTitle(),
                        lentBook.getAuthor(),
                        lentBook.getGenre(),
                        lentBook.getReleaseDate(),
                        lentBook.getPrice(),
                        oldNrOfBooks + 1)
                );
                actionMessage.setText("Yout returned the book " + lentBook.getTitle());
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
        EventQueue.invokeLater(() -> {
            BookStore bs = new BookStore();
            bs.setVisible(true);
        });
    }
}
