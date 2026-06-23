package com.app.MyBooks.OpenLibrary;

import com.app.MyBooks.Books.Book;

import java.util.List;

public class LibraryResponse {

    private List<Book> docs;

    public List<Book> getDocs() {
        return docs;
    }

    public void setDocs(List<Book> docs) {
        this.docs = docs;
    }
}