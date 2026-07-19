package com.app.MyBooks.Controllers;

import com.app.MyBooks.Model.DTO.NoteResponse;
import com.app.MyBooks.Model.Entities.BookNotes;
import com.app.MyBooks.Service.NotesService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NotesController {

    @Autowired
    NotesService notesService;

    @PostMapping(path = "/{isbn}")
    @Operation(summary = "Create new notes using an book ISBN")
    public ResponseEntity<BookNotes> createNote(@PathVariable(name = "isbn") String ISBN, @RequestBody NoteResponse response){
       BookNotes bookNotes = notesService.createNote(ISBN, response.getContent());
       return ResponseEntity.status(HttpStatus.CREATED).body(bookNotes);
    }

    @GetMapping(path = "/{isbn}")
    @Operation(summary = "Get all notes using an book ISBN")
    public List<BookNotes> getNotes(@PathVariable(name = "isbn") String ISBN){
        return notesService.getNotes(ISBN);
    }
}
