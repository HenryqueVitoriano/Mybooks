package com.app.MyBooks.OpenLibrary;

import com.app.MyBooks.Books.BookDoc;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class LibraryResponse {

    private List<BookDoc> docs;

}