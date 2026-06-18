package com.app.MyBooks;

import com.app.MyBooks.Books.Book;
import com.app.MyBooks.Books.BooksStatus;
import com.app.MyBooks.Repository.BooksRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyBooksApplicationTests {
	Book Livro = new Book();

	@Autowired
	BooksRepository booksRepository;

	@BeforeEach
	public void setup(){


		Livro.setISBN("978-8537808276");
		Livro.setAutor("Alexandre Dumas");
		Livro.setNumeroDePaginas(1664);
		Livro.setNota(10);
		Livro.setStatus(BooksStatus.LIDO);


	}

	@Test
	void savingAtDataBase() {
		booksRepository.save(Livro);
	}

}
