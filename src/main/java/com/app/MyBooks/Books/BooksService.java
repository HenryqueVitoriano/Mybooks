package com.app.MyBooks.Books;

import com.app.MyBooks.OpenLibrary.LibraryResponse;
import com.app.MyBooks.OpenLibrary.LibraryService;
import com.app.MyBooks.Repository.BooksRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {
    private final BooksRepository repository;
    private final LibraryService service;

    public BooksService(BooksRepository repository, LibraryService libraryService){
        this.repository = repository;
        this.service = libraryService;
    }

    public Book Save(String isbn){
        LibraryResponse response = service.buscarPorISBN(isbn);

        if (response == null){
            throw new RuntimeException("LIVRO NÃO ENCONTRADO");
        }

        Book books = new Book();

        books.setISBN(isbn);
        books.setNumeroDePaginas(response.getNumeroDePaginas());
        books.setNota(10);
        books.setCapaUrl(response.getCapaUrl());
        books.setTitulo(response.getTitulo());
        books.setAutor(response.getAutorFormatado());
        books.setStatus(BooksStatus.LIDO);
        repository.save(books);

        return books;
    }

    public List<Book> findAllBooks() {
        return repository.findAll();
    }

    public Book findByIsbn(String isbn) {
        return repository.findById(isbn).
                orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }
}
