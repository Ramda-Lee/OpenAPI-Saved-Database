package com.fpr.dto;

import com.fpr.annotation.Tel;
import com.fpr.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.*;

@AllArgsConstructor
@Getter
public class MemberDto{
    // 계층간 이동시 데이터가 변조될 위험이 없이 하기위해 Setter 제거

    @NotNull
    private String username;

    @NotNull
    @Max(150)
    @Min(1)
    private Integer age;

    @NotNull
    private String job;

    @NotNull
    @Email(message = "유효하지 않은 이메일 형식입니다.")
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String confirmPassword;

    @NotNull
    @Tel
    private String phoneNumber;

    public Member toEntity(){
        return Member.builder()
                .username(username)
                .age(age)
                .job(job)
                .email(email)
                .password(password)
                .phoneNumber(phoneNumber)
                .build();
    }
}
