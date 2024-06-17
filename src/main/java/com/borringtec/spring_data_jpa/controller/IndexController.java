package com.borringtec.spring_data_jpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @GetMapping
    public String welcome() {
        return "Welcome to API Spring Data JPA";
    }
}
