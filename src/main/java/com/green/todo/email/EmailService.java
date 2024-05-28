package com.green.todo.email;

import com.green.todo.email.model.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.green.todo.common.GlobalConst.NUM_DIGITS;
import static com.green.todo.common.GlobalConst.NUM_LETTERS;

@Service
@RequiredArgsConstructor
public class EmailService {

    private JavaMailSender mailSender;
    private RedisUtil redisUtil;
    private String otp;

    // 랜덤 otp 생성
    public void makeOneTimePassword() {
        int[] numberAscii = new int[NUM_DIGITS];
        int[] letterAscii = new int[NUM_LETTERS];
        for (int i = 0; i < NUM_DIGITS; i++) {
            numberAscii[i] = 48 + i;  // 0~9 숫자의 아스키코드는 48~57
        }
        for (int i = 0; i < NUM_LETTERS; i++) {
            letterAscii[i] = 65 + i;  // A~Z 문자의 아스키코드는 65~90
        }

    }
}
