package com.sparta.test03.controller;

import com.sparta.test03.entity.Member;
import com.sparta.test03.entity.MemberRequestDto;
import com.sparta.test03.entity.MemberResponseDto;
import com.sparta.test03.service.MemberService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 회원 조회
    @GetMapping("/member/{id}")
    public MemberResponseDto getMemberInfo(@PathVariable Long id) {
        return memberService.findMember(id);
    }

    // 회원 전체 조회
    @GetMapping("/member")
    public List<MemberResponseDto> getMemberList() {
        return memberService.findAllMember();
    }


    // 회원 등록
    @PostMapping("/member")
    public Member createMember(@RequestBody MemberRequestDto requestDto) {
        return memberService.createMember(requestDto);
    }
}