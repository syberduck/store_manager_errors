package org.example.backend.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class RegisterRequest {
    String name;
    String email;
    String password;

    public static RegisterRequest generate() {
        return RegisterRequest.builder()
                .email(System.currentTimeMillis() + "@email.com")
                .name("user_" + System.currentTimeMillis())
                .password("pass_" + System.currentTimeMillis())
                .build();
    }
}

