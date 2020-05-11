package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.NoDataException;
import com.example.demo.model.Note;

import com.example.demo.repository.NoteRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class controller {

	@Autowired
	NoteRepository noteRepository;

	/*
	 * Get All notes api for retrieving  the notes 
	 */
	
	@GetMapping("/notes")
	@ApiOperation(value = "returns all Notes", notes = "example notes", response = controller.class)
	public List<Note> getAllNotes() {
		System.out.println("Inside getAllNotes ");
		List<Note> note  = new ArrayList<>();
		try {
		
	
		note = noteRepository.findAll();
		System.out.println(note.size());
		
		// dummy expression TODO response object with status code and status description
		if(note == null || note.size() <= 5)
			throw new NoDataException("note", "id", null);
		//return noteRepository.findAll();
		
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return note;
	}

	/*
	 * retrieve notes based on id
	 */
	@GetMapping("/notes/{id}")
	public Note getNoteById(@PathVariable(value = "id") Long noteId) {
		// check for null or empty of id
		return noteRepository.findById(noteId).orElseThrow(() -> new NoDataException("note", "id", noteId));

	}

	@PostMapping("/psnotes")
	public Note createNote(@Valid @RequestBody Note note) {
		Note note1 = noteRepository.save(note);
		System.out.println(note1.getEmail());
		return note1;
	}

	@DeleteMapping("/notes/{id}")
	public void delete(@PathVariable(value = "id") Long noteId) {
		noteRepository.deleteById(noteId);
	}

}
