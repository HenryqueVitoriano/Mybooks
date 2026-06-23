    package com.app.MyBooks.OpenLibrary;

    import org.springframework.stereotype.Service;
    import org.springframework.web.client.RestTemplate;

    @Service
    public class LibraryService {

        private final RestTemplate restTemplate = new RestTemplate();

        public LibraryResponse buscarPorISBN(String isbn){
            String url = "https://openlibrary.org/search.json?isbn=" + isbn;
            return restTemplate.getForObject(url, LibraryResponse.class);
        }
    }
