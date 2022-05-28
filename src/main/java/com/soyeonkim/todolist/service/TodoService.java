package com.soyeonkim.todolist.service;

import com.soyeonkim.todolist.controller.dto.CreateTodoRequest;
import com.soyeonkim.todolist.controller.dto.MessageResponse;
import com.soyeonkim.todolist.entity.Todo;
import com.soyeonkim.todolist.entity.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public MessageResponse createTodo(CreateTodoRequest request) {
        todoRepository.save(Todo.builder()
                .content(request.getContent())
                .build());

        return MessageResponse.builder()
                .message("todo 생성이 완료되었습니다.")
                .build();
    }
}
