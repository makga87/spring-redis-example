package com.example.springapisample.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/class")
public class ClassMappingController {

    @GetMapping("/a")
    public void a(){}

    @GetMapping("/b")
    public void b(){}

    @PostMapping("/c")
    public void c(){}
}
