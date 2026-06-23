package com.app.MyBooks;

import com.app.MyBooks.Books.Book;
import com.app.MyBooks.Books.BooksStatus;
import com.app.MyBooks.OpenLibrary.LibraryControler;
import com.app.MyBooks.Repository.BooksRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Scanner;

@SpringBootTest
class MyBooksApplicationTests {
	Book Livro = new Book();
	Scanner scanner = new Scanner(System.in);

	@Autowired
	BooksRepository booksRepository;
	@Autowired
	LibraryControler libraryControler;

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

	@Test
	void LibraryTest(){
		String isbn = "8532530788";
		libraryControler.busca(isbn);
	}

}
