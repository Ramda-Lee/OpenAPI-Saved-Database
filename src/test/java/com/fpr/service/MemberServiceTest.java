package com.fpr.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fpr.domain.Member;
import com.fpr.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
public class MemberServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MemberService memberService;

    @Test
    @Transactional
    @DisplayName("무검증 회원가입 테스트")
    void 무검증_회원가입(){
        // given
        MemberDto memberDto = new MemberDto
                ("홍길동", 20, "무직",
                 "test@naver.com", "1234",
                 "1234", "01045525252");
        // when
        memberService.insertMember(memberDto.toEntity());
        Member findMember = memberService.getMember("홍길동");

        log.info("" + findMember.getMemberId());
        log.info("" + findMember.getCreatedAt());

        // then
        Assertions.assertThat(memberDto.getEmail()).isEqualTo(findMember.getEmail());
    }

    @Test
    @Transactional
    @DisplayName("검증 회원가입 테스트")
    void 검증_회원가입() throws Exception {
        // given
        MemberDto memberDto = new MemberDto
                ("홍길동", 20, "무직",
                        "test@naver.com", "1234",
                        "1234", "01045525252");

    }
}
