package com.wlnascimento.todolist.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wlnascimento.todolist.domain.model.Todo;
import com.wlnascimento.todolist.domain.repository.TodoRepository;

@Service
public class CadastroTodoService {

	@Autowired
	private TodoRepository todoRepository;

	public Todo create(Todo todo) {
		return todoRepository.save(todo);
	}

	public void delete(Long id) {
		todoRepository.deleteById(id);
	}

}
