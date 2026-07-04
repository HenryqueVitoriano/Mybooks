package com.app.MyBooks.Service;


import com.app.MyBooks.Model.DTO.LibraryResponse;
import lombok.ToString;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@ToString
public class LibraryService {

    private final RestTemplate restTemplate = new RestTemplate();
    LibraryResponse libraryResponse;

    public LibraryResponse openLibraryISBN(String isbn) {
        String url = "https://openlibrary.org/isbn/" + isbn +".json";
        return libraryResponse = restTemplate.getForObject(url, LibraryResponse.class);

    }

    public LibraryResponse openLibraryNameRequesition(String isbn){
        String url = "https://openlibrary.org/search.json?isbn=](https://openlibrary.org/search.json?isbn=)" + isbn;
        return libraryResponse = restTemplate.getForObject(url, LibraryResponse.class);
    }
}
