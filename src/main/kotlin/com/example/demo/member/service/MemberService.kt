package com.example.demo.member.service

import com.example.demo.common.authority.JwtTokenProvider
import com.example.demo.common.authority.TokenInfo
import com.example.demo.common.exception.InvalidInputException
import com.example.demo.member.dto.request.MemberSignupRequestDto
import com.example.demo.member.entity.Member
import com.example.demo.member.entity.MemberRole
import com.example.demo.member.repository.MemberRepository
import com.example.demo.member.repository.MemberRoleRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

import com.example.demo.common.status.ROLE
import com.example.demo.member.dto.request.MemberLoginRequestDto
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder

@Transactional
@Service
class MemberService(
    private val memberRepository: MemberRepository,
    private val memberRoleRepository: MemberRoleRepository,
    private val authenticationManagerBuilder: AuthenticationManagerBuilder,
    private val jwtTokenProvider: JwtTokenProvider
) {
    fun signUp(memberSignupRequestDto: MemberSignupRequestDto): String {

        var member: Member? = memberRepository.findByLoginId(memberSignupRequestDto.loginId)
        if (member != null) {
            throw InvalidInputException("loginId", "이미 존재하는 아이디입니다.")
        }

        member = memberSignupRequestDto.toEntity()
        memberRepository.save(member)

        val memberRole: MemberRole = MemberRole(null, ROLE.MEMBER, member)
        memberRoleRepository.save(memberRole)

        return "회원가입이 완료되었습니다."

    }

    fun login(memberLoginRequestDto: MemberLoginRequestDto): TokenInfo {
        val authenticationToken = UsernamePasswordAuthenticationToken(memberLoginRequestDto.loginId, memberLoginRequestDto.password)
        val authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken)

        return jwtTokenProvider.createToken(authentication)
    }
}