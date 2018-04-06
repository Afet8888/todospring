package home.afet.controller;

import home.afet.model.Todo;
import home.afet.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/todos")
public class TodoController {

    TodoService todoService;

    @GetMapping
    List<Todo> getAll() {
        return todoService.getAllTodo();
    }

    @GetMapping("/{id}")
    Todo getById(@PathVariable int id) {
        return todoService.get(id);
    }

    @PostMapping
    boolean postTodo(@RequestBody Todo todo) {
        return todoService.post(todo);
    }

    @DeleteMapping
    boolean deleteTodo(@RequestBody int id) {
        return todoService.delete(id);
    }

    @PutMapping
    boolean putTodo (@RequestBody Todo todo) {
        return todoService.put(todo);
    }

    @Autowired
    public void setTodoService(TodoService todoService) {
        this.todoService = todoService;
    }
}
