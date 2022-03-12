package com.example.reactivemongo.controller

import com.example.reactivemongo.document.Demo
import com.example.reactivemongo.service.DemoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class DemoController(
    private val demoService: DemoService,
) {

    @GetMapping("/get")
    suspend fun get(
        @RequestParam title: String
    ): List<Demo>? {
        return demoService.get(title)
    }

    @PostMapping("/create")
    suspend fun create(
        @RequestParam title: String
    ): ResponseEntity<String> {
        demoService.create(title)

        return ResponseEntity
            .ok()
            .body("success")
    }
}
