package com.app.MyBooks.OpenLibrary;

import com.app.MyBooks.Books.Book;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class LibraryResponse {

    private List<Book> docs;

}