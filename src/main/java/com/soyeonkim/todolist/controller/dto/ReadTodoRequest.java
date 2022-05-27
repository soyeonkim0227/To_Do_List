package com.soyeonkim.todolist.controller.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReadTodoRequest {

    private Integer id;

    private String content;
}
