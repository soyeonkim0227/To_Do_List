package com.soyeonkim.todolist.controller.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PatchTodoSuccessRequest {

    private Boolean isSuccess;
}
