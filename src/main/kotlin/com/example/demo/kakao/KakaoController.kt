package com.example.demo.kakao

import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class KakaoController {

    @GetMapping("/test")
    @Operation(summary = "Test operation", description = "Test operation description", tags = ["test"])
    fun index() : String? {
        return null
    }
}
