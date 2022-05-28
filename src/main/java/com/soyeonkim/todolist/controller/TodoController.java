package com.soyeonkim.todolist.controller;

import com.soyeonkim.todolist.controller.dto.CreateTodoRequest;
import com.soyeonkim.todolist.controller.dto.MessageResponse;
import com.soyeonkim.todolist.controller.dto.UpdateTodoRequest;
import com.soyeonkim.todolist.entity.Todo;
import com.soyeonkim.todolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public MessageResponse createTodo(@RequestBody CreateTodoRequest dto) {
        return todoService.createTodo(dto);
    }

    @PutMapping("/{todo-id}")
    public MessageResponse updateTodo(@RequestBody UpdateTodoRequest dto, @PathVariable("todo-id") Integer id) {
        return todoService.updateTodo(dto, id);
    }

    @DeleteMapping("/{todo-id}")
    public MessageResponse deleteTodo(@PathVariable("todo-id") Integer id) {
        return todoService.deleteTodo(id);
    }

    @GetMapping
    public List<Todo> readAllTodo() {
        return todoService.getTodo();
    }

    @GetMapping("/{todo-id}")
    public Todo readTodo(@PathVariable("todo-id") Integer id) {
        return todoService.getTodo(id);
    }
}
