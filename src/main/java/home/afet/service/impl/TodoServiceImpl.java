package home.afet.service.impl;

import home.afet.model.Todo;
import home.afet.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TodoServiceImpl implements TodoService {

    List<Todo> todos;

    @Override
    public List<Todo> getAllTodo() {
        return todos;
    }

    @Override
    public boolean post(Todo todo) {
        Todo tempTodo = todos.stream().filter(elem -> elem.getId() == todo.getId()).findAny().orElseGet(null);
        if (Objects.isNull(tempTodo)) {
            todos.add(todo);
            return true;
        } else
            return false;
    }

    @Override
    public Todo get(int id) {
        return todos.parallelStream().filter(elem -> elem.getId() == id).findAny().orElseGet(null);
    }

    @Override
    public boolean delete(int id) {
        Todo tempTodo = todos.stream().filter(elem -> elem.getId() == id).findAny().orElseGet(null);
        if (Objects.isNull(tempTodo)) {
            return false;
        } else
            todos.remove(tempTodo);
        return true;
    }

    @Override
    public boolean put(Todo todo) {
        Todo tempTodo = todos.stream().filter(elem -> elem.getId() == todo.getId()).findAny().orElseGet(null);
        if (Objects.isNull(tempTodo)) {
            return false;
        } else {
            tempTodo.setDate(todo.getDate());
            tempTodo.setText(todo.getText());
            tempTodo.setTitle(todo.getTitle());
            tempTodo.setDone(todo.isDone());
            return true;
        }
    }
        @Autowired
        public void setTodos (List < Todo > todos) {
            this.todos = todos;
        }
    }
