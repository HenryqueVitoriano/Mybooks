package com.app.MyBooks.OpenLibrary;

import com.app.MyBooks.Books.Book;
import com.app.MyBooks.Books.BooksControler;
import com.app.MyBooks.Books.BooksStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryControler {
    private final LibraryService libraryService;
    private BooksControler booksControler;

    public LibraryControler(LibraryService libraryService) {
        this.libraryService = libraryService;
    }


    @PostMapping("/buscar/{isbn}")
    public void busca(String isbn) {
        LibraryResponse libraryResponse = libraryService.buscarPorISBN(isbn);
        Book book = new Book();

        book.setTitulo(libraryResponse.getDocs().get(0).getTitulo());
        book.setAutor(libraryResponse.getDocs().get(0).getAutor());
        book.setNumeroDePaginas(libraryResponse.getDocs().get(0).getNumeroDePaginas());
        book.setStatus(BooksStatus.LIDO);
        book.setISBN(isbn);
        book.setCapaUrl(libraryResponse.getDocs().get(0).getCapaUrl());

        booksControler.POST(book);
    }
}
