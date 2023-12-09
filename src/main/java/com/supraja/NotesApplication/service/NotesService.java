package com.supraja.NotesApplication.service;

import com.supraja.NotesApplication.entity.NotesEntity;

import java.util.List;

public interface NotesService {
    //Finding all notes
    List<NotesEntity> findNotes ();

    void addNote(NotesEntity note);

    // Retrieve single note based on id
    NotesEntity findNoteById  (int id);

    // Update note based on id
    void updateNote(NotesEntity note);

    // delete note based on id
    void deleteNote(int id);
}
