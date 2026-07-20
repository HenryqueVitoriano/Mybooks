package com.app.MyBooks.Model.Entities;

import com.app.MyBooks.Model.DTO.LibraryResponse;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    private String ISBN;

    private String author;
    private String title;
    private Integer numberOfPages;
    private String coverUrl;

    @Max(10)
    @Min(0)
    private Integer note;

    @Enumerated(EnumType.STRING)
    BooksStatus status;

    @JsonManagedReference
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    List<BookNotes> bookNotes = new ArrayList<>();

    public Book(String isbn, LibraryResponse response, LibraryResponse responseName){
        this.setISBN(isbn);
        this.setNumberOfPages(response.getNumberOfPages());
        this.setNote(10);
        this.setCoverUrl(response.getCoverUrl());
        this.setTitle(response.getTitle());
        this.setAuthor(responseName.getAuthorName());
        this.setStatus(BooksStatus.WISH);
    }

}
