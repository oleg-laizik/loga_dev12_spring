package loga.dev12.spring;

import loga.dev12.spring.entity.Note;
import loga.dev12.spring.service.NoteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class LauncherSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(LauncherSpringBootApplication.class, args);
        NoteService noteService = new NoteService();

        System.out.println(noteService.add(new Note("Title1", "Context1")));
        System.out.println(noteService.getById(2));
        noteService.deleteById(4);
        System.out.println(noteService.listAll());
        noteService.update(new Note("Title 1", "Context 1"));

        System.out.println(noteService.add(new Note( "Title2", "Context2")));
        System.out.println(noteService.getById(3));
        noteService.deleteById(5);
        System.out.println(noteService.listAll());
        noteService.update(new Note("Title 2", "Context 2"));
    }
}

