package com.app.MyBooks.Service;

import com.app.MyBooks.Exceptions.BookNotFoundException;
import com.app.MyBooks.Model.Entities.Book;
import com.app.MyBooks.Model.DTO.LibraryResponse;
import com.app.MyBooks.Model.Entities.BooksStatus;
import com.app.MyBooks.Repository.BooksRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {
    private final BooksRepository repository;
    private final LibraryService service;

    public BooksService(BooksRepository repository, LibraryService libraryService) {
        this.repository = repository;
        this.service = libraryService;
    }

    public Book createBook(String isbn) {
        LibraryResponse response = service.openLibraryISBN(isbn);
        LibraryResponse responseName = service.openLibraryNameRequesition(isbn);

        if (response == null || responseName == null) {
            throw new BookNotFoundException();
        }

        Book books = new Book(isbn, response, responseName);
        repository.save(books);

        return books;
    }


    public List<Book> findAllBooks() {
        return repository.findAll();
    }

    public Book getBookByIsbn(String isbn) {
      Book book = repository.findByISBN(isbn);

       if (book == null){
           throw new BookNotFoundException();
       }

       return book;
    }

    public Book delete(String ISBN) {
        Book book = repository.findByISBN(ISBN);

        if (book == null){
            throw new BookNotFoundException();
        }

        repository.delete(book);
        return book;
    }

    public Book updateNoteAndStatus(String isbn, Integer note, String status) {
        Book book = repository.findByISBN(isbn);

        if (book == null){
            throw new BookNotFoundException();
        }

        book.setNote(note);
        book.setStatus(BooksStatus.valueOf(status));

        return repository.save(book);
    }
}
