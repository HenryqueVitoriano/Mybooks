package com.app.MyBooks.Service;

import com.app.MyBooks.Model.Entities.Book;
import com.app.MyBooks.Model.Entities.BookNotes;
import com.app.MyBooks.Repository.BookNotesRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class NotesService {

    private final BooksService booksService;
    private final BookNotesRepository bookNotesRepository;


    NotesService(BookNotesRepository bookNotesRepository, BooksService booksService){
        this.booksService = booksService;
        this.bookNotesRepository = bookNotesRepository;
    }

    public BookNotes createNote(String isbn, String content) {
        Book book = booksService.findByIsbn(isbn);

            BookNotes newNote = new BookNotes();

            newNote.setCreatedAt(LocalDate.now());
            newNote.setContent(content);
            newNote.setBook(book);

            bookNotesRepository.save(newNote);

            return newNote;

    }

    public List<BookNotes> getNotes(String isbn) {
        booksService.findByIsbn(isbn);

        return bookNotesRepository.findByBook_ISBN(isbn);
    }

    public BookNotes updateContent(Long id, String content) {
        if (bookNotesRepository.existsByID(id)){
            BookNotes bookNotes = bookNotesRepository.findByID(id);

            bookNotes.setContent(content);
            bookNotesRepository.save(bookNotes);

            return bookNotes;
        }

        return null;
    }

    public BookNotes deleteNote(Long id) {
        if (bookNotesRepository.existsByID(id)){

            BookNotes bookNotes = bookNotesRepository.findByID(id);

            bookNotesRepository.delete(bookNotes);
            return bookNotes;
        }

        return null;
    }
}
