package com.app.MyBooks.Service;

import com.app.MyBooks.Model.Entities.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
class BooksServiceTest {
    @Autowired
    BooksService booksService;

    @Test
    @DisplayName("Should get a book when everything is OK")
    void createBookSuccessfully() {
      String isbn = "978-8544001516";
      Optional<Book> book = Optional.ofNullable(booksService.createBook(isbn));

      assertThat(book.isPresent()).isTrue();
    }


}