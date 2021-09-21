package com.wlnascimento.todolist.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wlnascimento.todolist.domain.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
