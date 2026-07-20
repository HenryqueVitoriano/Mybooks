package com.app.MyBooks.Repository;

import com.app.MyBooks.Model.Entities.Book;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
@ActiveProfiles("test")
class BooksRepositoryTest {
    @Autowired
    EntityManager entityManager;

    @Autowired
    BooksRepository booksRepository;

    @Test
    @DisplayName("Should get book successfully from DB")
    void findByISBNSuccess() {
        String isbn = "1234567891234";
        this.createBook(isbn);

      Optional<Book> book = Optional.ofNullable(this.booksRepository.findByISBN(isbn));

      assertThat(book.isPresent()).isTrue();
    }

    @Test
    @DisplayName("Should not get book successfully from DB")
    void findByISBNFailed(){
        String isbn = "1234567891234";
        Optional<Book> book = Optional.ofNullable(this.booksRepository.findByISBN(isbn));

        assertThat(book.isPresent()).isFalse();
    }

    private void createBook(String isbn){
        Book book = new Book();
        book.setISBN(isbn);
        book.setTitle("Teste");

        entityManager.persist(book);
    }
}