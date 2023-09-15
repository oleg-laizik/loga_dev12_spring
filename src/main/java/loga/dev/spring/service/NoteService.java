package loga.dev.spring.service;

import loga.dev.spring.entity.Note;
import loga.dev.spring.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    public Note add(Note note) {
        return noteRepository.save(note);
    }

    public void deleteById(long id) {
        Optional<Note> note = noteRepository.findById(id);
        note.ifPresentOrElse(
                n -> noteRepository.deleteById(id),
                () -> {
                    throw new RuntimeException("Note with ID " + id + " not found");
                }
        );
    }

    public void update(Note note) {
        if (noteRepository.existsById(note.getId())) {
            noteRepository.save(note);
        } else {
            throw new RuntimeException("Note with ID " + note.getId() + " not found");
        }
    }

    public Note getById(long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note with ID " + id + " not found"));
    }
}