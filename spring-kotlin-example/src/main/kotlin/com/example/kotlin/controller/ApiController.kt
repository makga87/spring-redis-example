package com.example.kotlin.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class ApiController {

    @GetMapping("/hello")
    fun listOfApiTest() : List<String> = listOf(
        "hello world",
        "hi world",
        "mario world"
    );
}