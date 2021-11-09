package com.wlnascimento.todolist;

import com.wlnascimento.todolist.domain.model.Todo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {

    private static final String API_ROOT = "http://localhost:8080/todo-list";

    private Todo createTask() {
        Todo todo = new Todo();
        todo.setTitle("Pagar escola");
        todo.setDone(false);
        return todo;
    }

    @Test
    public void whenCreatingNewTask_thenOk() {
        Todo todo = createTask();

        Response response = RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(todo)
                .post(API_ROOT);

        assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
    }

    @Test
    public void whenToGetAllTheTasks_thenOk(){
        Response response = RestAssured.get(API_ROOT);

        assertEquals(HttpStatus.OK.value(),response.getStatusCode());
    }
}
