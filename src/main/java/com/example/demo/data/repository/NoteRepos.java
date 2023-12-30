package com.example.demo.data.repository;

import com.example.demo.data.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NoteRepos extends JpaRepository<Note, UUID> {

}
