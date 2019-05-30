package com.books.assignment3.decorator;

import com.books.assignment3.model.database.Book;

public abstract class BookDecorator implements BookDecoratorInterface {
    protected Book bookToDecorate;

    public BookDecorator(Book bookToDecorate) {
        this.bookToDecorate = bookToDecorate;
    }

    @Override
    public void setNumberOfBooks(int numberOfBooks) {
        bookToDecorate.setNumberOfBooks(numberOfBooks);
    }
}
