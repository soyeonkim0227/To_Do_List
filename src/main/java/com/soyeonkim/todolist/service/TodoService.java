package com.soyeonkim.todolist.service;

import com.soyeonkim.todolist.controller.dto.CreateTodoRequest;
import com.soyeonkim.todolist.controller.dto.MessageResponse;
import com.soyeonkim.todolist.controller.dto.UpdateTodoRequest;
import com.soyeonkim.todolist.entity.Todo;
import com.soyeonkim.todolist.entity.TodoRepository;
import com.soyeonkim.todolist.exception.exceptions.NotFoundTodoException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public MessageResponse createTodo(CreateTodoRequest request) {
        todoRepository.save(Todo.builder()
                .content(request.getContent())
                .isSuccess(false)
                .build());

        return MessageResponse.builder()
                .message("todo 생성이 완료되었습니다.")
                .build();
    }

    @Transactional
    public MessageResponse updateTodo(UpdateTodoRequest dto, Integer id) {
        Todo todo = todoRepository.findById(id)
                        .orElseThrow(NotFoundTodoException::new);

        todo.setContent(dto.getContent());

        return MessageResponse.builder()
                .message(id + "번 아이디 todo 수정이 완료되었습니다.")
                .build();
    }

    @Transactional
    public MessageResponse deleteTodo(Integer id) {
        todoRepository.deleteById(id);

        return MessageResponse.builder()
                .message(id + "번 아이디 todo 삭제가 완료되었습니다.")
                .build();
    }

    public List<Todo> getTodo() {
        System.out.println(SecurityContextHolder.getContext().getAuthentication());
        return todoRepository.findAll();
    }

    public Todo getTodo(Integer id) {

        return todoRepository.findById(id).orElseThrow(NotFoundTodoException::new);
    }

    @Transactional
    public MessageResponse patchTodo(Boolean isSuccess, Integer id) {

        Todo todo = todoRepository.findById(id).orElseThrow(NotFoundTodoException::new);
        todo.setIsSuccess(isSuccess);

        return MessageResponse.builder()
                .message(id + "번 아이디 todo 완료 여부가 변경되었습니다.")
                .build();
    }
}
