package org.example.repository;

import org.example.model.TodoModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITodoRepository extends MongoRepository<TodoModel, String> {
    TodoModel getById(String id);
}
