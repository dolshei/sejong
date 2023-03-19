package com.prototype.sejong.controller;

import com.prototype.sejong.domain.user.dto.UserRequestDto;
import com.prototype.sejong.domain.user.repository.UserJpaRepository;
import com.prototype.sejong.domain.user.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
public class UserControllerTest {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Autowired
    private UserService userService;

    @Test
    @DisplayName("BaseEntity 등록")
    void BaseTimeEntityTest() throws Exception {
        // given(준비) : 어떠한 데이터가 준비 되었을 때
        LocalDateTime now = LocalDateTime.of(2021, 8, 5, 22, 31, 0);
        userService.save(UserRequestDto.builder()
                        .name("이은식")
                        .email("adfe@aedt.com")
                        .build());
/*
        // when(실행) : 어떠한 함수를 실행하면
        List<User> users = userJpaRepository.findAll();

        // then(검증) : 어떠한 결과가 나와야 한다.
        UserResponseDto userResponseDto = userService.findByEmail("adfe@aedt.com");

        System.out.println(">>>>>> createDate = " + userResponseDto.getCreateDate()
                + ", modifiedDate = " + userResponseDto.getModifiedDate());

        Assertions.assertThat(userResponseDto.getCreateDate()).isAfter(now);
        Assertions.assertThat(userResponseDto.getModifiedDate()).isAfter(now);
        */
    }

}
