package com.myla.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ToDoListController {

    @Autowired
    private ToDoListRepository toDoListRepository;

    @GetMapping("/show")
    public String show(Model model, ToDoEntry toDoEntry) {
        model.addAttribute("toDoEntries", toDoListRepository.findAll());
        return "index";
    }

    @PostMapping("/add")
    public String add(ToDoEntry toDoEntry) {
        toDoListRepository.save(toDoEntry);
        return "redirect:/show";
    }

}
