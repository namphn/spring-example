package org.example.controller;

import org.example.model.TodoModel;
import org.example.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @Autowired
    private TodoService service;

    @GetMapping("/todo/todo/{id}")
    public ResponseEntity getTodo(@PathVariable String id) {
        TodoModel model =  service.getTodo(id);
        return ResponseEntity.ok(model);
    }

    @PostMapping("/todo/add")
    public ResponseEntity addTodo(@RequestBody TodoModel model) {
        boolean isInsert = service.insertNewTodo(model);
        return ResponseEntity.ok(isInsert);
    }

    @PutMapping("/todo/edit/{id}")
    public ResponseEntity editTodo(@RequestBody TodoModel model, @PathVariable String id) {
        return ResponseEntity.ok(service.editTodo(model, id));
    }

    @DeleteMapping("/todo/delete/{id}")
    public ResponseEntity editTodo( @PathVariable String id) {
        return ResponseEntity.ok(service.deleteTodo(id));
    }
}
