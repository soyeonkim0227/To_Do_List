package com.soyeonkim.todolist.controller;

import com.soyeonkim.todolist.controller.dto.CreateTodoRequest;
import com.soyeonkim.todolist.controller.dto.MessageResponse;
import com.soyeonkim.todolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
}
