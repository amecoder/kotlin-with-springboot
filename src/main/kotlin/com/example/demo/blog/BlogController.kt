package com.example.demo.blog

import com.example.demo.blog.application.BlogService
import com.example.demo.blog.dto.BlogDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/blog")
@RestController
class BlogController(val blogService: BlogService) {
    @PostMapping("")
    fun search(@RequestBody blogDto: BlogDto): String? {
        return blogService.searchKakao(blogDto)
    }
}
