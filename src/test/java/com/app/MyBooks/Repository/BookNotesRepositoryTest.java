package com.app.MyBooks.Repository;

import com.app.MyBooks.Model.Entities.BookNotes;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;


@DataJpaTest
@ActiveProfiles("test")
class BookNotesRepositoryTest {

    @Autowired
    EntityManager entityManager;

    @Test
    void findByBook_ISBN() {
    }

    @Test
    void findByID() {
    }

}