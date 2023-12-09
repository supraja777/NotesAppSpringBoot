package com.supraja.NotesApplication.controller;

import com.supraja.NotesApplication.entity.NotesEntity;
import com.supraja.NotesApplication.service.NotesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/notes")
public class NotesController {

    private NotesService notesService;

    @Autowired
    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

    @GetMapping("")
    public String getAllNotes (Model theModel) {

        List<NotesEntity> allNotes = notesService.findNotes();


        theModel.addAttribute("notes", allNotes);

        return "notes";
    }

    @GetMapping("/showFormAddNote")
    public String showFormAddNote(Model theModel) {
        NotesEntity note = new NotesEntity();
        theModel.addAttribute("note", note);

        return "note-form";

    }

    @PostMapping("/addNote")
    public String addNote(@Valid @ModelAttribute ("note") NotesEntity note, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "note-form";
        }

        notesService.addNote(note);
        return "redirect:/notes";
    }

    @GetMapping("/findNote")
    public  ResponseEntity<NotesEntity> findNoteById() {
        int id = 2;

        NotesEntity note =  notesService.findNoteById(id);

        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @GetMapping("/deleteNote")
    public String deleteNoteById( @RequestParam("noteId") int id) {
        notesService.deleteNote(id);

        return "redirect:/notes";
    }

    @GetMapping("/updateNote")
    public void updateNote() {


        int id = 2;
        NotesEntity note = notesService.findNoteById(id);

        note.setDescription("Updated note");

        notesService.updateNote(note);

    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("noteId") int theId, Model model) {

        NotesEntity note = notesService.findNoteById(theId);

        model.addAttribute("note", note);

        return "note-form";
    }
}
