package com.example.demo.member.controller

import com.example.demo.common.authority.TokenInfo
import com.example.demo.common.dto.BaseResponse
import com.example.demo.member.dto.request.MemberLoginRequestDto
import com.example.demo.member.dto.request.MemberSignupRequestDto
import com.example.demo.member.service.MemberService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/member")
@RestController
class MemberController(
    private val memberService: MemberService
) {

    @PostMapping("/signup")
    fun signUp(@RequestBody @Valid memberSignupRequestDto: MemberSignupRequestDto): BaseResponse<Unit> {
        val resultMsg: String  = memberService.signUp(memberSignupRequestDto)
        return BaseResponse(message = resultMsg)
    }

    @PostMapping("/login")
    fun login(@RequestBody @Valid memberLoginRequestDto: MemberLoginRequestDto): BaseResponse<TokenInfo> {
        val tokenInfo: TokenInfo = memberService.login(memberLoginRequestDto)
        return BaseResponse(data = tokenInfo)
    }
}