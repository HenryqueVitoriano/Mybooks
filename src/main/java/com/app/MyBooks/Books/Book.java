package com.app.MyBooks.Books;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.*;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    private String ISBN;

    private String Author;
    private String Title;
    private Integer numerOfPages;
    private String coverUrl;
    private Integer note;

    @Enumerated(EnumType.STRING)
    BooksStatus status;

}
