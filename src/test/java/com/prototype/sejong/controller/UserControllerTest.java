package com.prototype.sejong.controller;

import com.prototype.sejong.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserControllerTest {

    @Autowired
    private UserJpaRepository userJpaRepository;

}
