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
        String isbnLimpo = isbn.replace("\"", "").trim();
        LibraryResponse response = service.buscarPorISBN(isbnLimpo);

        Book books = new Book();

        books.setISBN(isbnLimpo);
        Integer paginas = response.getDocs().get(0).getNumeroDePaginas();
        books.setNumeroDePaginas(paginas != null ? paginas : 0); // Se for nulo, grava 0
        books.setNota(10);
        books.setCapaUrl(response.getDocs().get(0).getCapaUrl());
        books.setTitulo(response.getDocs().get(0).getTitulo());
        books.setAutor(response.getDocs().get(0).getAutor());
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
