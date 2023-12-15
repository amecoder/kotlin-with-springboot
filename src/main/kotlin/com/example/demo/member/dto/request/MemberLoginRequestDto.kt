package com.example.demo.member.dto.request

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank

data class MemberLoginRequestDto (
    @field:NotBlank
    @JsonProperty("loginId")
    private val _loginId: String?,

    @field:NotBlank
    @JsonProperty("password")
    private val _password: String?,
) {
    val loginId: String
        get() = _loginId!!
    val password: String
        get() = _password!!
}