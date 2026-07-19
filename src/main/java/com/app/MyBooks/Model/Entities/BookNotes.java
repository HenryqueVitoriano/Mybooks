package com.app.MyBooks.Model.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookNotes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    LocalDate createdAt;

    @Column(columnDefinition = "TEXT")
    String content;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "book_isbn")
    private Book book;

}
