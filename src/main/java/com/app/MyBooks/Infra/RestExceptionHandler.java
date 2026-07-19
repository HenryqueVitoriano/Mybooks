package com.app.MyBooks.Infra;

import com.app.MyBooks.Exceptions.BookNotFoundException;
import com.app.MyBooks.Exceptions.NoteNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    private ResponseEntity<String> BookNotFoundHandler(BookNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
    }

    @ExceptionHandler(NoteNotFoundException.class)
    private ResponseEntity<String> NoteNotFoundHandler(NoteNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Note not found");
    }
}
