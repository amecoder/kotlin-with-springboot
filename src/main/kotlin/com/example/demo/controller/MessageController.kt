package com.example.demo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MessageController {
    @GetMapping("/")
//    fun index(@RequestParam("name") name: String) = "Hello, $name!"
    fun index() = listOf(
            Message("1", "Hello!"),
            Message("2", "Bonjour!"),
            Message("3", "Privet!"),
    )
}

class Message(val id: String?, val text: String) {

}
