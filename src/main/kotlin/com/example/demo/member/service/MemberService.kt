package com.example.demo.member.service

import com.example.demo.common.exception.InvalidInputException
import com.example.demo.member.dto.request.MemberSignupRequestDto
import com.example.demo.member.entity.Member
import com.example.demo.member.repository.MemberRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Transactional
@Service
class MemberService(
    private val memberRepository: MemberRepository
) {
    fun signUp(memberSignupRequestDto: MemberSignupRequestDto): String {

        var member: Member? = memberRepository.findByLoginId(memberSignupRequestDto.loginId)
        if (member != null) {
            throw InvalidInputException("loginId", "이미 존재하는 아이디입니다.")
        }

        member = memberSignupRequestDto.toEntity()
        memberRepository.save(member)

        return "회원가입이 완료되었습니다."

    }
}