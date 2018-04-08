package home.afet.service.impl;

import home.afet.model.Todo;
import home.afet.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TodoServiceImpl implements TodoService {

    private List<Todo> todos;


    @Override
    public boolean addAll(List<Todo> allTodos) {
        allTodos.forEach(this::put);
        return true;
    }

    @Override
    public List<Todo> getAllTodo() {
        return todos;
    }

    @Override
    public boolean post(Todo todo) {
        if (todos.parallelStream().anyMatch(el -> el.getId() == todo.getId())) return false;
        todos.add(todo);
        return true;
    }

    @Override
    public Todo get(int id) {
        if (todos.parallelStream().anyMatch(el -> el.getId() == id))
            return todos.parallelStream().filter(elem -> elem.getId() == id).findAny().get();
        else return null;
    }

    @Override
    public boolean delete(int id) {
        if (todos.parallelStream().noneMatch(el -> el.getId() == id)) return false;
        else {
            todos.removeIf(el -> el.getId() == id);
            //todos.remove(todos.stream().filter(el->el.getId() == id).findAny().get());
            return true;
        }
    }

    @Override
    public boolean put(Todo todo) {
        if (findIndex(todo.getId()) == -1) return false;
        Todo tempTodo = todos.stream().filter(elem -> elem.getId() == todo.getId()).findAny().get();
        tempTodo.setDate(todo.getDate());
        tempTodo.setText(todo.getText());
        tempTodo.setTitle(todo.getTitle());
        tempTodo.setDone(todo.isDone());
        return true;
    }

    @Autowired
    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }

    int findIndex(int id) {

        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getId() == id) return i;
        }
        return -1;
    }
}
