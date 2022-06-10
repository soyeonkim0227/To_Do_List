package com.soyeonkim.todolist.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpUserRequest {

    private String name;

    private Integer number;

    private Integer badScore;

    private String accountId;

    private String accountPassword;
}
