package com.books.assignment3.decorator;

import com.books.assignment3.model.database.Book;

public class BookAvailability extends BookDecorator {

    public BookAvailability(Book bookToDecorate) {
        super(bookToDecorate);
    }

    @Override
    public void setNumberOfBooks(int numberOfBooks){
        bookToDecorate.setNumberOfBooks(numberOfBooks);
        if(numberOfBooks == 0){
            System.out.println("Unavailable");
        }else{
            System.out.println("Available");
        }

    }
}
