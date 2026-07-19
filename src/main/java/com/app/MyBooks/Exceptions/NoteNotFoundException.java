package com.app.MyBooks.Exceptions;

public class NoteNotFoundException extends RuntimeException{
    public NoteNotFoundException(){
        super("Note not found");
    }
}
