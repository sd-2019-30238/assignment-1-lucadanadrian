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
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Connection.class);
    BookDAO book = applicationContext.getBean("bookDAO", BookDAO.class);

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
                book.deleteFromTable(Integer.parseInt(textField2.getText()));
                textField2.setText("");
            }
        });
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                book.insertTable(new Book(1,
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
    }

    protected void goToLogOut(ActionEvent e){
        this.setVisible(false);
        logIn.setVisible(true);
    }

    protected void selectFilter(ActionEvent e){
//        System.out.println(comboBox1.getSelectedItem().toString());
        if(comboBox1.getSelectedItem().toString().equals("Author")){
            textArea1.setText(book.selectByAuthor(textField1.getText().toLowerCase()).toString());
        }
        if(comboBox1.getSelectedItem().toString().equals("Title")){
            textArea1.setText(book.selectByTitle(textField1.getText().toLowerCase()).toString());
        }
        if(comboBox1.getSelectedItem().toString().equals("Genre")){
            textArea1.setText(book.selectByGenre(textField1.getText().toLowerCase()).toString());
        }
        if(comboBox1.getSelectedItem().toString().equals("Release Year")){
            textArea1.setText(book.selectByDate(Integer.parseInt(textField1.getText())).toString());
        }
    }

    protected void showAllBooks(ActionEvent e){
        textArea1.setText(book.selectAll().toString());
    }

    public static void main(String[] args){
        EventQueue.invokeLater( () -> {BookManagement bm = new BookManagement();
            bm.setVisible(true);});
    }
}
