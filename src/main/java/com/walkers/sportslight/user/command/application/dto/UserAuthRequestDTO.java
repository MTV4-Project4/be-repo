package com.walkers.sportslight.user.command.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UserAuthRequestDTO {

    public record signUpDTO(
            @NotBlank(message = "닉네임을 입력해 주세요.")
            String nickname,

            //@Email(message = "올바른 이메일 주소를 입력해 주세요.")
            @NotBlank(message = "아이디를 입력해 주세요.")
            String userId,

            @Schema(description = "패스워드", defaultValue = "1234")
            String password,

            @Positive(message = "올바른 연도를 입력")
            int year,

            @Positive(message = "올바른 월을 입력")
            int month,

            @Positive(message = "올바른 일을 입력")
            int day,

            @NotBlank(message = "휴대폰 번호를 입력해 주세요.")
            String phoneNumber,

            @NotBlank(message = "주소를 입력해 주세요.")
            String address,

            @Positive(message = "키는 양수로 입력해주세요")
            double height,

            @Positive(message = "몸무게는 양수로 입력해주세요")
            double weight
    ) {

        @Override
        public String toString() {
            return "signUpDTO{" +
                    "nickname='" + nickname + '\'' +
                    ", userId='" + userId + '\'' +
                    ", password='" + "[PROTECTED]" + '\'' +
                    ", year=" + year +
                    ", month=" + month +
                    ", day=" + day +
                    ", height=" + height +
                    ", weight=" + weight +
                    '}';
        }
    }

    public record loginDTO(
            //@Email(message = "올바른 이메일 주소를 입력해 주세요.")
            @NotBlank(message = "아이디를 입력해 주세요.")
            String userId,

            @NotBlank(message = "비밀번호를 입력해 주세요.")
            String password
    ){
        @Override
        public String toString() {
            return "loginDTO{" +
                    "userId='" + userId + '\'' +
                    ", password='" + "[PROTECTED]" + '\'' +
                    '}';
        }
    }
}
