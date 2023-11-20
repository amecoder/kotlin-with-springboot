package com.example.demo.blog.application

import com.example.demo.blog.dto.BlogDto
import org.springframework.stereotype.Service

@Service
class BlogService {
    fun searchKakao(blogDto: BlogDto): String? {
        println(blogDto.toString())
        return "Search Kakao"
    }
}