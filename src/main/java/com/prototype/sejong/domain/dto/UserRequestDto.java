package com.prototype.sejong.domain.dto;

import com.prototype.sejong.domain.entity.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class UserRequestDto {
    private String email;
    private String name;

    @Builder
    public UserRequestDto(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public User toEntity() {
        return User.builder()
                .email(email)
                .name(name)
                .build();
    }
}
