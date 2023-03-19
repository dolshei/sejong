package com.prototype.sejong.domain.user.dto;

import com.prototype.sejong.domain.user.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponseDto {
    private final Long userId;
    private final String email;
    private final String name;
    public LocalDateTime createDate;

    private LocalDateTime modifiedDate;

    public UserResponseDto(User user) {
        this.userId = user.getUserId();
        this.email = user.getEmail();
        this.name = user.getName();
        this.createDate = user.getCreateDate();
        this.modifiedDate = user.getModifiedDate();
    }
}
