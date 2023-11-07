package com.example.localevents.service;

import com.example.localevents.entity.User;
import com.example.localevents.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j2
@Transactional // 비즈니스 로직을 담당하는 서비스.(에러가 발생하면 로직을 수행하기 이전 상태로 콜백해줌)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User saveUser(User user){
        validateDuplicateUser(user);
        return userRepository.save(user);
    }

    private void validateDuplicateUser(User user) {
        User findUser = userRepository.findByEmail(user.getEmail());
        if(findUser != null){
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }

}
