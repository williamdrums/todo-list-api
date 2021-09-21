package com.wlnascimento.todolist.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wlnascimento.todolist.domain.model.Todo;
import com.wlnascimento.todolist.domain.repository.TodoRepository;
import com.wlnascimento.todolist.domain.service.CadastroTodoService;

@RestController
@RequestMapping("todo-list")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private CadastroTodoService todoService;


    @GetMapping()
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> findById(@PathVariable Long id) {

        Optional<Todo> todo = todoRepository.findById(id);

        if (todo.isPresent()) {
            return ResponseEntity.ok(todo.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo create(@Valid @RequestBody Todo todo) {
        return todoService.create(todo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!todoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        todoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
