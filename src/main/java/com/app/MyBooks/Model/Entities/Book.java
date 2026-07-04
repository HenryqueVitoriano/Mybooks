package com.app.MyBooks.Model.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

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

}
