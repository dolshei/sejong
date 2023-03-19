package com.prototype.sejong.domain.user.dto;

import com.prototype.sejong.domain.user.entity.User;
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
