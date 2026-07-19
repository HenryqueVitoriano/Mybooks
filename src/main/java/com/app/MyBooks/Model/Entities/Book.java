package com.app.MyBooks.Model.Entities;

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

    @OneToMany(mappedBy = "book")
    List<BookNotes> bookNotes = new ArrayList<>();

}
