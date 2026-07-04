package com.app.MyBooks.Service;

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
        if (response == null) {
            throw new RuntimeException("Book not found");
        }

        Book books = new Book();

        books.setISBN(isbn);
        books.setNumerOfPages(response.getNumberOfPages());
        books.setNote(10);
        books.setCoverUrl(response.getCoverUrl());
        books.setTitle(response.getTitle());
        books.setAuthor(response.getAuthorName());
        books.setStatus(BooksStatus.WISH);

        repository.save(books);

        return books;
    }

    public void save(Book book){
        repository.save(book);
    }

    public List<Book> findAllBooks() {
        return repository.findAll();
    }

    public Book findByIsbn(String isbn) {
        return repository.findById(isbn).
                orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public void delete(Book book) {
        repository.delete(book);
    }
}
