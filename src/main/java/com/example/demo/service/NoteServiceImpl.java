package com.example.demo.service;


import com.example.demo.data.entity.Note;
import com.example.demo.data.repository.NoteRepos;
import com.example.demo.service.dto.NoteDto;
import com.example.demo.service.exception.NoteNotFoundException;
import com.example.demo.service.mapper.NoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.*;

@Service
public class NoteServiceImpl implements NoteService{
    @Autowired
    private NoteRepos noteRepos;
    @Autowired private NoteMapper noteMapper;

    @Override
    public List<NoteDto> listAll() {
        return noteMapper.toNoteDtos(noteRepos.findAll());
    }

    @Override
    public NoteDto add(NoteDto note) {
        Note entity = noteMapper.toNoteEntity(note);
        entity.setId(null);
        return noteMapper.toNoteDto(noteRepos.save(entity));
    }

    @Override
    public List<NoteDto> addAll(Collection<NoteDto> notes) {
        Collection<Note> savedNotes = noteRepos.saveAll(noteMapper.toNoteEntities(notes));
        return noteMapper.toNoteDtos(savedNotes);
    }

    @Override
    public void deleteById(UUID id) throws NoteNotFoundException {
        getById(id);
        noteRepos.deleteById(id);
    }

    @Override
    public void update(NoteDto note) throws NoteNotFoundException {
        if (Objects.isNull(note.getId())) {
            throw new NoteNotFoundException();
        }
        getById(note.getId());
        noteRepos.save(noteMapper.toNoteEntity(note));
    }

    @Override
    public NoteDto getById(UUID id) throws NoteNotFoundException {
        Optional<Note> optionalNote = noteRepos.findById(id);
        if (optionalNote.isPresent()) {
            return noteMapper.toNoteDto(optionalNote.get());
        } else {
            throw new NoteNotFoundException(id);
        }
    }
}
