package com.prototype.sejong.controller;

import com.prototype.sejong.domain.entity.Hello;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/helloWorld/string")
    @ResponseBody
    public String helloWorldString() {
        return "hello";
    }

    @GetMapping("/helloWorld/json")
    @ResponseBody
    public Hello helloWorldJson() {
        Hello hello = new Hello();
        hello.setMessage("Hello");
        return hello;
    }

    @GetMapping("/helloWorld/page")
    public String HelloWorldPage() {
        return "helloWorld";
    }
}
