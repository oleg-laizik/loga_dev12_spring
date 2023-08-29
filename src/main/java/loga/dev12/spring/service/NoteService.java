package loga.dev12.spring.service;

import loga.dev12.spring.entity.Note;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

@Service
public class NoteService {

    private final Map<Long, Note> noteMap = new HashMap<>();
    private final Random random = new Random();

    public List<Note> listAll() {
        return new ArrayList<>(noteMap.values());
    }

    public Note add(Note note) {
        long id = generateUniqueId();
        note.setId(id);
        noteMap.put(id, note);
        return note;
    }

    public void deleteById(long id) {
        Optional<Note> note = getNoteById(id);
        note.ifPresentOrElse(
                n -> noteMap.remove(id),
                () -> {
                    throw new RuntimeException("Note with ID " + id + " not found");
                }
        );
    }

    public void update(Note note) {
        long id = note.getId();
        Optional<Note> existingNote = getNoteById(id);
        existingNote.ifPresentOrElse(
                n -> {
                    n.setTitle(note.getTitle());
                    n.setContent(note.getContent());
                    noteMap.put(id, n);
                },
                () -> {
                    throw new RuntimeException("Note with ID " + id + " not found");
                }
        );
    }

    public Optional<Note> getById(long id) {
        return Optional.ofNullable(noteMap.get(id));
    }

    private long generateUniqueId() {
        long id;
        do {
            id = random.nextLong();
        } while (id <= 0 || noteMap.containsKey(id));
        return id;
    }

    private Optional<Note> getNoteById(long id) {
        return Optional.ofNullable(noteMap.get(id));
    }
}