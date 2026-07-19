package com.app.MyBooks.Exceptions;

public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException(){
        super("Book not found");
    }
}
