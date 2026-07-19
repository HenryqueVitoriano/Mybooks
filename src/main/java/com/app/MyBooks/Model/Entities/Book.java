package com.app.MyBooks.Model.Entities;

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

}
