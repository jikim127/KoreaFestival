package com.example.localevents.service;

import com.example.localevents.dto.MemberFormDTO;
import com.example.localevents.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User createUser(){
        MemberFormDTO memberFormDTO = new MemberFormDTO();
        memberFormDTO.setEmail("test@email.com");
        memberFormDTO.setPassword("1234");
        memberFormDTO.setName("김지민");
        return User.createUser(memberFormDTO,passwordEncoder);
    }

    @Test
    @DisplayName("회원가입 테스트")
    public void saveUserTest() {
        User user = createUser();
        User saveUser = userService.saveUser(user);

        assertEquals(user.getEmail(), saveUser.getEmail()); // 요청했던값과 실제 저장된값을 비교.
        assertEquals(user.getPassword(), saveUser.getPassword());
        assertEquals(user.getName(), saveUser.getName());
        assertEquals(user.getRole(), saveUser.getRole());
    }
}