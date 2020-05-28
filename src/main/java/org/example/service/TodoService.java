package org.example.service;

import org.example.model.TodoModel;
import org.example.repository.ITodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private ITodoRepository repository;

    public TodoModel getTodo(String id){
        return repository.getById(id);
    }

    public boolean insertNewTodo(TodoModel model){
        TodoModel insertedModel = repository.save(model);
        return insertedModel != null;
    }

    public boolean editTodo(TodoModel model, String id) {
        TodoModel existTodo = repository.getById(id);
        existTodo.setName(model.getName());
        existTodo.setStatus(model.getStatus());

        TodoModel saved = repository.save(existTodo);
        return saved != null;
    }

    public boolean deleteTodo(String id) {
        TodoModel deleteRequestModel = repository.getById(id);
        repository.delete(deleteRequestModel);
        return true;
    }
}
