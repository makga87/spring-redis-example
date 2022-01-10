package com.example.springapisample.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MethodMappingController {

    @PostMapping("/method/d")
    public void d(){}

    @PostMapping("/method/e")
    public void e(){}

    @PostMapping("/method/f")
    public void f(){}
}
