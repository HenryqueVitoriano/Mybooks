package com.app.MyBooks.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksControler {

    private final BooksService booksService;

    @Autowired
    public BooksControler(BooksService booksService){
        this.booksService = booksService;

    }

    @PostMapping
    public ResponseEntity<Book> POST(@RequestBody String isbn){
        String isbnLimpo = isbn.replace("\"", "").trim();
        Book book = booksService.Save(isbnLimpo);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(book);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books = booksService.findAllBooks();
        return ResponseEntity.ok(books);

    }
    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn){
        Book book = booksService.findByIsbn(isbn);
        return ResponseEntity.ok(book);
    }
}
