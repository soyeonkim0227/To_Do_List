package com.soyeonkim.todolist.controller;

import com.soyeonkim.todolist.controller.dto.MessageResponse;
import com.soyeonkim.todolist.controller.dto.SignUpUserRequest;
import com.soyeonkim.todolist.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public MessageResponse login(@RequestBody SignUpUserRequest dto) {
        return authService.createSignUping(dto);
    }
}
