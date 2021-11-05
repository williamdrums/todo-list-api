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

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("todo-list")
public class TodoController {

    @Autowired
    private CadastroTodoService todoService;

    @GetMapping()
    public List<Todo> findAll() {
        return todoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> findById(@PathVariable Long id) {

        Optional<Todo> todo = todoService.findById(id);

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

    @PutMapping("/{id}")
    public ResponseEntity<Todo> update(@PathVariable Long id, @RequestBody Todo todo) {
        if (todo.getId() != id) {
            return ResponseEntity.badRequest().build();
        }

        if (!todoService.existeById(id)) {
            return ResponseEntity.notFound().build();
        }
        todo.setId(id);
        todoService.create(todo);

        return ResponseEntity.ok(todo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!todoService.existeById(id)) {
            return ResponseEntity.notFound().build();
        }
        todoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
