package com.app.MyBooks.Books;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksControler {

    BooksService booksService;

    @PostMapping
    public void POST(Book book){

    }
}
