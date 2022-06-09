package com.soyeonkim.todolist.service;

import com.soyeonkim.todolist.controller.dto.MessageResponse;
import com.soyeonkim.todolist.controller.dto.SignUpUserRequest;
import com.soyeonkim.todolist.entity.User;
import com.soyeonkim.todolist.entity.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    // 함수, 메서드 이름 1. 동사 + 명사, 2. 동사 + 명사 + 명사
    public MessageResponse createSignUping(SignUpUserRequest request) {
        userRepository.save(User.builder()
                .name(request.getName())
                .number(request.getNumber())
                .badScore(request.getBadScore())
                .accountId(request.getAccountId())
                .accountPassword(request.getAccountPassword())
                .build());

        return MessageResponse.builder()
                .message("user 회원가입이 완료되었습니다.")
                .build();
    }
}
