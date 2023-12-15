package com.example.demo.common.status

enum class Gender(val desc: String) {
    MALE("남"),
    FEMALE("여")
}

enum class ResultCode(val msg: String) {
    SUCCESS("성공"),
    FAIL("실패")
}