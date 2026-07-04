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
    private BooksStatus booksStatus;

    @Autowired
    public BooksControler(BooksService booksService){
        this.booksService = booksService;

    }

    @PostMapping(path = "/{isbn}")
    public ResponseEntity<Book> POST(@PathVariable String isbn){
        Book book = booksService.createBook(isbn);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(book);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books = booksService.findAllBooks();
        return ResponseEntity.ok(books);

    }
    @GetMapping(path = "/{isbn}")
    public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn){
        Book book = booksService.findByIsbn(isbn);
        return ResponseEntity.ok(book);
    }

    @DeleteMapping(path = "/{isbn}")
    public ResponseEntity<Book> deleteBook(@PathVariable String isbn){
        Book book = booksService.findByIsbn(isbn);
        if (book != null){
            booksService.delete(book);
            return ResponseEntity.ok(book);
        }else {
            throw new RuntimeException("Book not found");
        }

    }

    @PutMapping(path = "/{isbn}")
    public ResponseEntity<Book> updateNoteAndStatus(@PathVariable String isbn, @RequestParam("note") Integer note, @RequestParam("status") String status){
        Book book = booksService.findByIsbn(isbn);
        if (book != null){
            book.setStatus(BooksStatus.valueOf(status.toUpperCase()));
            book.setNote(note);

            booksService.save(book);
            return ResponseEntity.ok(book);
        }else {
            throw new RuntimeException("Book not found");
        }
    }

}
