package com.app.MyBooks.Controllers;

import com.app.MyBooks.Service.BooksService;
import com.app.MyBooks.Model.Entities.BooksStatus;
import com.app.MyBooks.Model.Entities.Book;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksService booksService;
    ;

    @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;

    }

    @PostMapping(path = "/{isbn}")
    @Operation(summary = "Create a new book using ISBN")
    public ResponseEntity<Book> createNewBook(@PathVariable String isbn) {
        Book book = booksService.createBook(isbn);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    @GetMapping()
    @Operation(summary = "See all books saved in your DB")
    public List<Book> getAllBooks() {
        return booksService.findAllBooks();

    }

    @GetMapping(path = "/{isbn}")
    @Operation(summary = "See the specifically book using ISBN")
    public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn) {
        Book book = booksService.findByIsbn(isbn);
        return ResponseEntity.ok(book);
    }

    @DeleteMapping(path = "/{isbn}")
    @Operation(summary = "Delete a book using ISBN")
    public ResponseEntity<Book> deleteBook(@PathVariable String isbn) {
        Book book = booksService.findByIsbn(isbn);
        booksService.delete(book);
        return ResponseEntity.ok(book);


    }

    @PutMapping(path = "/{isbn}")
    @Operation(summary = "Update note and status values")
    public ResponseEntity<Book> updateNoteAndStatus(@PathVariable String isbn,
                                                    @RequestParam("note") Integer note,
                                                    @RequestParam("status") String status) throws RuntimeException {
        Book book = booksService.findByIsbn(isbn);

        try {
            book.setStatus(BooksStatus.valueOf(status.toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Illegal argument");
        }

        book.setNote(note);

        booksService.save(book);
        return ResponseEntity.ok(book);
    }

}
