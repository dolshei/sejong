package com.prototype.sejong.service;

import com.prototype.sejong.domain.dto.UserRequestDto;
import com.prototype.sejong.domain.dto.UserResponseDto;
import com.prototype.sejong.domain.entity.User;
import com.prototype.sejong.global.error.UserNotFoundException;
import com.prototype.sejong.repository.UserJpaRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserJpaRepository userJpaRepository;

    @Transactional
    public Long save(UserRequestDto userRequestDto) {
        userJpaRepository.save(userRequestDto.toEntity());

        return userJpaRepository.findByEmail(userRequestDto.getEmail()).getUserId();
    }

    @Transactional(readOnly = true)
    public UserResponseDto findById(Long id) {
        User user = userJpaRepository.findById(id).orElseThrow(UserNotFoundException::new);

        return new UserResponseDto(user);
    }

    @Transactional(readOnly = true)
    public UserResponseDto findByEmail(String email) {
        User user = userJpaRepository.findByEmail(email);
        if (user.getEmail().isEmpty()) throw new UserNotFoundException();
        return new UserResponseDto(user);
    }

    @Transactional(readOnly = true)
    public List<UserResponseDto> findByName(String name) {
        return userJpaRepository.findByName(name)
                .stream()
                .map(UserResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<UserResponseDto> findAllUser() {
        return userJpaRepository.findAll()
                .stream()
                .map(UserResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long update(Long id, UserRequestDto userRequestDto) {
        User modifiedUser = userJpaRepository.findById(id).orElseThrow(UserNotFoundException::new);
        modifiedUser.setEmail(userRequestDto.getEmail());
        modifiedUser.setName(userRequestDto.getName());
        return id;
    }

    @Transactional
    public void delete(Long id) {
        userJpaRepository.deleteById(id);
    }
}
