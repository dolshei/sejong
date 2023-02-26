package com.prototype.sejong.controller;

import com.prototype.sejong.entity.User;
import com.prototype.sejong.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserControllerTest {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @PostMapping("/user")
    public User save() {
        User user = User.builder()
                .email("abdcd34@test.com")
                .name("곰탱이")
                .build();

        return userJpaRepository.save(user);
    }

    @GetMapping("/findUser/{name}")
    public User findUserByName(@PathVariable String name) {
        return userJpaRepository.findByName(name);
    }
}
