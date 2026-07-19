package com.app.MyBooks;

import com.app.MyBooks.Model.Entities.Book;
import com.app.MyBooks.Controllers.BooksController;
import com.app.MyBooks.Model.Entities.BooksStatus;
import com.app.MyBooks.Model.DTO.LibraryResponse;
import com.app.MyBooks.Service.LibraryService;
import com.app.MyBooks.Repository.BooksRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class MyBooksApplicationTests {
    Book book = new Book();

    @Autowired
    private BooksRepository booksRepository;
    @Autowired
    private LibraryService libraryService;
    @Autowired
    private BooksController booksControler;



    @Test
    void savingAtDataBase() {
        book.setISBN("978-8537808276");
        book.setAuthor("Alexandre Dumas");
        book.setNumberOfPages(1664);
        book.setNote(10);
        book.setStatus(BooksStatus.READ);
        booksRepository.save(book);
    }

    @Test
    void LibraryTest() {
        String isbn = "9788535914849";
        LibraryResponse response = libraryService.openLibraryISBN(isbn);
        System.out.println(response.toString());
    }

}
