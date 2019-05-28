package com.books.assignment3.service.query;

import com.books.assignment3.dao.BookDAO;
import com.books.assignment3.model.database.Book;
import com.books.assignment3.model.query.BookQueryDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class BookQueryService {
    @Autowired
    private BookDAO bookDAO;

    public List<BookQueryDTO> seeAllBooks() {
        List<BookQueryDTO> bookQueryDTOS = new ArrayList<>();
        List<Book> books = bookDAO.selectAll();
        for (Book book : books) {
            BookQueryDTO bookQueryDTO = new BookQueryDTO();
            bookQueryDTO.setId(book.getId());
            bookQueryDTO.setTitle(book.getTitle());
            bookQueryDTO.setAuthor(book.getAuthor());
            bookQueryDTO.setGenre(book.getGenre());
            bookQueryDTO.setReleaseDate(book.getReleaseDate());
            bookQueryDTO.setPrice(book.getPrice());
            bookQueryDTO.setNumberOfBooks(book.getNumberOfBooks());
            bookQueryDTOS.add(bookQueryDTO);
        }
        return bookQueryDTOS;
    }
}
