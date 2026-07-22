package com.app.MyBooks.Service;

import com.app.MyBooks.Model.DTO.LibraryResponse;
import com.app.MyBooks.Model.Entities.Book;
import com.app.MyBooks.Repository.BooksRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BooksServiceTest {


    @Mock
    LibraryService libraryService;
    @Mock
    BooksRepository booksRepository;

    @InjectMocks
    private BooksService booksService;


    @Test
    @DisplayName("Should get a book when everything is OK")
    void createBookSuccessfully() {
        String isbn = "978-8544001516";
        List<String> authorName = List.of("Machado de assis");

        LibraryResponse response = new LibraryResponse();
        LibraryResponse responseName = new LibraryResponse();


        responseName.setAuthor(authorName);

        response.setTitle("Mémorias postumas de brás cubas");
        response.setNumberOfPages(345);

        when(libraryService.openLibraryISBN(isbn)).thenReturn(response);
        when(libraryService.openLibraryNameRequesition(isbn)).thenReturn(responseName);

        Book book = booksService.createBook(isbn);

        assertThat(book).isNotNull();


    }

}