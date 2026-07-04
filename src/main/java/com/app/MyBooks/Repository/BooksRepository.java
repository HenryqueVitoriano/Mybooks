package com.app.MyBooks.Repository;

import com.app.MyBooks.Model.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<Book, String>{
}
