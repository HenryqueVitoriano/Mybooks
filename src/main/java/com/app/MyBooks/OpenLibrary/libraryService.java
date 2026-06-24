package com.app.MyBooks.OpenLibrary;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LibraryService {

    private final RestTemplate restTemplate = new RestTemplate();
    LibraryResponse libraryResponse;

    public LibraryResponse buscarPorISBN(String isbn) {
        String url = "https://openlibrary.org/search.json?isbn=" + isbn;
        return libraryResponse = restTemplate.getForObject(url, LibraryResponse.class);

    }
}
