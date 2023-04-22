package com.sparta.test03.service;

import com.sparta.test03.entity.Member;
import com.sparta.test03.entity.MemberRequestDto;
import com.sparta.test03.entity.MemberResponseDto;
import com.sparta.test03.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원 상세 조회
    @Transactional(readOnly = true)
    public MemberResponseDto findMember(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new NullPointerException("회원 상세 조회 실패")
        );
        return new MemberResponseDto(member);
    }

    // 회원 전체 조회
    @Transactional(readOnly = true)
    public List<MemberResponseDto> findAllMember() {
        return memberRepository.findAll().stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    // 회원 등록
    public Member createMember(MemberRequestDto requestDto) {
        Member member = new Member(requestDto);
        memberRepository.save(member);
        return member;
    }
}