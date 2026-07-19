package com.app.MyBooks.Model.Entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class BookNotes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    LocalDate createdAt;

    @Column(columnDefinition = "TEXT")
    String content;

    @ManyToOne
    @JoinColumn(name = "book_isbn")
    private Book book;

}
