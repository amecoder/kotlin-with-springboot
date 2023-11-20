package com.example.demo.blog.dao;

import com.example.demo.blog.entity.WordCount
import org.springframework.data.jpa.repository.JpaRepository

interface WordCountRepository : JpaRepository<WordCount, String> {
}