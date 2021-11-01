package com.wlnascimento.todolist.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wlnascimento.todolist.domain.model.Todo;
import com.wlnascimento.todolist.domain.repository.TodoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroTodoService {

    @Autowired
    private TodoRepository todoRepository;

    public Todo create(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public Optional<Todo> findById(Long id) {
        return todoRepository.findById(id);
    }

    public boolean existeById(Long id) {
        return todoRepository.existsById(id);
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);
    }

}
