package com.app.MyBooks.Repository;

import com.app.MyBooks.Books.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Book, String>{
}
