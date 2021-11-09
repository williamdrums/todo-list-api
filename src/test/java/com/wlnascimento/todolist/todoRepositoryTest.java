package com.wlnascimento.todolist;

import com.wlnascimento.todolist.domain.model.Todo;
import com.wlnascimento.todolist.domain.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class todoRepositoryTest {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void whenCreatingNewTask_thenOk() {
        Todo todo = new Todo(null, "Nova Tarefa", false);
        todoRepository.save(todo);
        Integer contTask = todoRepository.findAll().size();
        assertEquals(1, contTask);
    }
}
