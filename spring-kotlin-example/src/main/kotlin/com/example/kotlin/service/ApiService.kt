package com.example.kotlin.service

import org.springframework.stereotype.Service
import java.util.*

@Service
class ApiService {

    fun firstApiService(): List<String> {
        return listOf(
            "hello world",
            "hi world",
            "mario world"
        );
    }
}