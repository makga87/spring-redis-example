package com.example.kotlin.controller

import com.example.kotlin.service.ApiService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class ApiController {

    @Autowired
    lateinit var apiService: ApiService

    @GetMapping("/hello")
    fun listOfApiTest(): List<String> = apiService.firstApiService();
}