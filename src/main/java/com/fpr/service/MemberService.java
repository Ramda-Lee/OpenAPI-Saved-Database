package com.fpr.service;

import com.fpr.domain.Member;
import com.fpr.persistence.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 맴버 등록
    @Transactional
    public void insertMember(Member member){
        memberRepository.save(member);
    }

    // 맴버 조회
    @Transactional(readOnly = true)
    public Member getMember(String username) {
        Optional<Member> getMember = memberRepository.findByUsername(username);
        return getMember.orElseThrow(() -> new NoSuchElementException("검색된 맴버가 없습니다."));
    }

}
