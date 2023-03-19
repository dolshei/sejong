package com.prototype.sejong.domain.user.service;

import com.prototype.sejong.domain.user.dto.UserRequestDto;
import com.prototype.sejong.domain.user.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    Long save(UserRequestDto userRequestDto);

    UserResponseDto findById(Long id);

    UserResponseDto findByEmail(String email);

    List<UserResponseDto> findByName(String name);

    List<UserResponseDto> findAllUser();

    Long update(Long id, UserRequestDto userRequestDto);

    void delete(Long id);
}
