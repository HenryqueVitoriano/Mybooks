package com.app.MyBooks.OpenLibrary;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LibraryService {

    private final RestTemplate restTemplate = new RestTemplate();
    LibraryResponse libraryResponse;

    public LibraryResponse buscarPorISBN(String isbn) {
        String url = "https://openlibrary.org/isbn/" + isbn +".json";
        return libraryResponse = restTemplate.getForObject(url, LibraryResponse.class);

    }

    public LibraryResponse buscarNomeAutor(String authorKey) {
        String url = "https://openlibrary.org" + authorKey + ".json";
        return libraryResponse = restTemplate.getForObject(url, LibraryResponse.class);
    }
}
