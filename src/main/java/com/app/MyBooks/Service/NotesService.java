package com.app.MyBooks.Service;

import com.app.MyBooks.Exceptions.BookNotFoundException;
import com.app.MyBooks.Exceptions.NoteNotFoundException;
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


    NotesService(BookNotesRepository bookNotesRepository, BooksService booksService) {
        this.booksService = booksService;
        this.bookNotesRepository = bookNotesRepository;
    }

    public BookNotes createNote(String isbn, String content) {
        Book book = booksService.getBookByIsbn(isbn);


        BookNotes newNote = new BookNotes();

        newNote.setCreatedAt(LocalDate.now());
        newNote.setContent(content);
        newNote.setBook(book);

        bookNotesRepository.save(newNote);

        return newNote;

    }

    public List<BookNotes> getNotes(String isbn) {
         booksService.getBookByIsbn(isbn);

        return bookNotesRepository.findByBook_ISBN(isbn);
    }

    public BookNotes updateContent(Long id, String content) {
        BookNotes bookNotes = bookNotesRepository.findByID(id);

        if (bookNotes == null) {
            throw new NoteNotFoundException();
        }

        bookNotes.setContent(content);

        return bookNotesRepository.save(bookNotes);
    }

    public BookNotes deleteNote(Long id) {
        BookNotes bookNotes = bookNotesRepository.findByID(id);

        if (bookNotes == null) {
            throw new NoteNotFoundException();
        }

        bookNotesRepository.delete(bookNotes);
        return bookNotes;

    }

    public BookNotes getSpecificallyNote(String isbn, Long id) {
        booksService.getBookByIsbn(isbn);
        
        BookNotes bookNotes = bookNotesRepository.findByID(id);

        if (bookNotes == null){
            throw new NoteNotFoundException();
        }

        return bookNotes;
    }
}
