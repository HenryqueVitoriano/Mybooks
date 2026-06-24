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

    private String Autor;
    private String Titulo;
    private Integer numeroDePaginas;
    private String capaUrl;
    private Integer nota;

    @Enumerated(EnumType.STRING)
    BooksStatus status;

}
