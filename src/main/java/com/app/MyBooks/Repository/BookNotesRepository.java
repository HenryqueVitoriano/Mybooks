package com.app.MyBooks.Repository;

import com.app.MyBooks.Model.Entities.BookNotes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookNotesRepository extends JpaRepository<BookNotes, String> {
    List<BookNotes> findByBook_ISBN(String ISBN);
    BookNotes findByID(Long id);
    boolean existsByID(Long ID);
}
