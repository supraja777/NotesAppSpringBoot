package com.supraja.NotesApplication.service;

import com.supraja.NotesApplication.entity.NotesEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesServiceImpl implements NotesService{

    // Add EntityManager
    private EntityManager theEntityManager;

    // create Constructor for entity manager
    public NotesServiceImpl(EntityManager theEntityManager) {
        this.theEntityManager = theEntityManager;
    }
    @Override
    public List<NotesEntity> findNotes() {
        TypedQuery<NotesEntity> theQuery = theEntityManager.createQuery("FROM NotesEntity", NotesEntity.class);

        List<NotesEntity> notes = theQuery.getResultList();

        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void addNote(NotesEntity note) {
        theEntityManager.merge(note);
    }

    @Override
    public NotesEntity findNoteById(int id) throws RuntimeException {
            return theEntityManager.find(NotesEntity.class, id);
    }

    @Override
    @Transactional
    public void updateNote(NotesEntity note) {
        theEntityManager.merge(note);
    }

    @Override
    @Transactional
    public void deleteNote(int id) {
        NotesEntity noteToDelete =  theEntityManager.find(NotesEntity.class, id);
        if (noteToDelete == null) {
            System.out.println("Note with id " + id + "not found");
        } else {
            theEntityManager.remove(noteToDelete);
        }
    }
}
