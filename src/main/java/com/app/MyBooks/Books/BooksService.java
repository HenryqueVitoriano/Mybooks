package com.app.MyBooks.Books;

import com.app.MyBooks.Repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksService {
    @Autowired
    private BooksRepository booksRepository;

    public void POST(Book books){
        booksRepository.save(books);
    }
}
