package com.example.demo.user;

import com.example.demo.util.PasswordEncoder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PasswordEncoderTest {

    @Test
    public void encode() {
        String pwd = "asdf1234!";

        String encoding = PasswordEncoder.encode(pwd);

        System.out.println(encoding);
    }

    @Test
    public void matches() {
        String pwd = "$2a$04$Havh.DXT3JJOZ9N9eTp.r.znBHx01MS9DREjsj06TmfQYGywuh.U2";
        String checkPwd = "asdf1234!";

        if (PasswordEncoder.matches(checkPwd, pwd)) {
            System.out.println("matched");
        } else {
            System.out.println("not match");
        }
    }
}
