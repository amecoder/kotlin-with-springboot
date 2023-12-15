package com.example.demo.member.dto

import com.example.demo.common.status.Gender
import java.time.LocalDate

data class MemberDto (
    val id: Long?,
    val loginId: String,
    val password: String,
    val name: String,
    val brithDate: LocalDate,
    val gender: Gender,
    val email: String,
)