package home.afet.service;

import home.afet.model.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getAllTodo();
    boolean post (Todo todo);
    Todo get (int id);
    boolean delete (int id);
    boolean put (Todo todo);
}
