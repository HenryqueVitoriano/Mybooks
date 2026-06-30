package com.app.MyBooks;

import com.app.MyBooks.Books.Book;
import com.app.MyBooks.Books.BooksControler;
import com.app.MyBooks.Books.BooksStatus;
import com.app.MyBooks.OpenLibrary.LibraryResponse;
import com.app.MyBooks.OpenLibrary.LibraryService;
import com.app.MyBooks.Repository.BooksRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class MyBooksApplicationTests {
    Book Livro = new Book();

    @Autowired
    private BooksRepository booksRepository;
    @Autowired
    private LibraryService libraryService;
    @Autowired
    private BooksControler booksControler;


    @Test
    public void setup() {


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
    void LibraryTest() {
        String isbn = "9788535914849";
        LibraryResponse response = libraryService.buscarPorISBN(isbn);

        Livro.setNumeroDePaginas(response.getDocs().get(0).getNumeroDePaginas());
        if (Livro.getNumeroDePaginas() == null || Livro.getNumeroDePaginas().describeConstable().isEmpty()) {
            System.out.println("ATRIBUTO VAZIO");
        } else {
            System.out.println(Livro.getNumeroDePaginas());
        }
    }


    @Test
    void GetTest() {
        booksControler.getAllBooks();
    }

}
