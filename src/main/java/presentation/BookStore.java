package presentation;

import connection.Connection;
import dao.BookDAO;
import dao.UserDAO;
import model.Book;
import model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
    private String clientEmail;
    ApplicationContext appContext = new AnnotationConfigApplicationContext(Connection.class);
    UserDAO users = appContext.getBean("userDAO", UserDAO.class);
    BookDAO book = appContext.getBean("bookDAO", BookDAO.class);
    Map<String, Integer> bookMap = new HashMap<String, Integer>();
    Set<Map.Entry<String, Integer>> entrySet = bookMap.entrySet();
    static int numbersOfLentBooks = 0;


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

                    numbersOfLentBooks++;
                    bookMap.put(clientEmail, numbersOfLentBooks);

                    System.out.println(bookMap.get(clientEmail));

//                    for(Map.Entry<String, Integer> mb : entrySet){
//                        System.out.println(mb.getKey() + " " + mb.getValue());
//                    }

//                    for (User u : users.selectAll()) {
//                        if (u.getEmail().equals(clientEmail)) {
//                            System.out.println(u.getId());
//                        }
//                    }
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

                if (numbersOfLentBooks > 0) {
                    numbersOfLentBooks--;
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
                } else {
                    actionMessage.setText("You dont't have any books to return");
                }

            }

        });
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
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
