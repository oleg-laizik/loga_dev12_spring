package loga.dev.spring.controllers;

import loga.dev.spring.entity.Note;
import loga.dev.spring.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @GetMapping("/add")
    public ModelAndView getAddPage(Note note) {
        ModelAndView modelAndView = new ModelAndView("add");
        modelAndView.addObject("note", note);
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView add(@ModelAttribute("note") Note note) {
        ModelAndView modelAndView = new ModelAndView("redirect:/list");
        noteService.add(note);
        return modelAndView;
    }

    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        Note note = noteService.getById(id);
        modelAndView.addObject("note", note);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editNote(@ModelAttribute("note") Note note) {
        ModelAndView modelAndView = new ModelAndView("redirect:/list");
        noteService.update(note);
        return modelAndView;
    }

    @PostMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/list");
        noteService.deleteById(id);
        return modelAndView;
    }

    @GetMapping("/list")
    public ModelAndView listAll() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("notes", noteService.listAll());
        return modelAndView;
    }
}