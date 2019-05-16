package presentation;

import bll.BookBLL;
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

public class BookManagement extends JFrame{
    static LogIn logIn = new LogIn();
    private JPanel panel;
    private JComboBox comboBox1;
    private JTextArea textArea1;
    private JTextField textField1;
    private JButton showAllButton;
    private JTextField textField2;
    private JButton deleteButton;
    private JButton insertButton;
    private JTextField titleField;
    private JTextField authorField;
    private JTextField genreField;
    private JTextField yearField;
    private JTextField priceField;
    private JTextField numberOfBooksField;
    private JButton logOutButton;
    private JButton showUsersButton;
//    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Connection.class);
//    BookDAO book = applicationContext.getBean("bookDAO", BookDAO.class);
    BookBLL books = new BookBLL();

    public BookManagement(){
        setTitle("BookManagement");
        setContentPane(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setSize(1000,400);
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectFilter(e);
            }
        });
        showAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAllBooks(e);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                books.deleteBook(Integer.parseInt(textField2.getText()));
                textField2.setText("");
            }
        });
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                books.insertBook(new Book(1,
                        titleField.getText(),
                        authorField.getText(),
                        genreField.getText(),
                        Integer.parseInt(yearField.getText()),
                        Integer.parseInt(priceField.getText()),
                        Integer.parseInt(numberOfBooksField.getText())
                ));
                titleField.setText("");
                authorField.setText("");
                genreField.setText("");
                yearField.setText("");
                priceField.setText("");
                numberOfBooksField.setText("");
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goToLogOut(e);
            }
        });
        showUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ApplicationContext appContext = new AnnotationConfigApplicationContext(Connection.class);
                UserDAO users= appContext.getBean("userDAO",UserDAO.class);
                String text="";
                for(User u: users.selectAll()){
                    text += u.getId() + " " +u.getEmail()+ " "+ u.getLastName()+ " "+u.getFirstName() + "\n";
                }
                textArea1.setText(text);
            }
        });
    }

    protected void goToLogOut(ActionEvent e){
        this.setVisible(false);
        logIn.setVisible(true);
    }

    protected void selectFilter(ActionEvent e){
//        System.out.println(comboBox1.getSelectedItem().toString());
        if(comboBox1.getSelectedItem().toString().equals("Author")){
            textArea1.setText(books.selectBookByAuthor(textField1.getText().toLowerCase()).toString());
        }
        if(comboBox1.getSelectedItem().toString().equals("Title")){
            textArea1.setText(books.selectBookByTitle(textField1.getText().toLowerCase()).toString());
        }
        if(comboBox1.getSelectedItem().toString().equals("Genre")){
            textArea1.setText(books.selectBookByGenre(textField1.getText().toLowerCase()).toString());
        }
        if(comboBox1.getSelectedItem().toString().equals("Release Year")){
            textArea1.setText(books.selectBookByYear(Integer.parseInt(textField1.getText())).toString());
        }
    }

    protected void showAllBooks(ActionEvent e){
        String text="";
        for(Book b : books.selectAllBooks()){
            text +=b.toString();
        }
        textArea1.setText(text);
    }

    public static void main(String[] args){
        EventQueue.invokeLater( () -> {BookManagement bm = new BookManagement();
            bm.setVisible(true);});
    }
}
