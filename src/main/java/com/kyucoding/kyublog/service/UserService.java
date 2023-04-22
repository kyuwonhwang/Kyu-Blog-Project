package com.kyucoding.kyublog.service;

import com.kyucoding.kyublog.dto.user.UserRequest;
import com.kyucoding.kyublog.model.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder; //쓸 수 있는 근거 - SecurityConfig 에 BEAN 등록함

    //insert, update, delete -> 꼭 직접 try catch 처리해야한다.

    @Transactional
    public void 회원가입(UserRequest.JoinInDTO joinInDTO) {
        try {
            //1. 패스워드 암호화
            joinInDTO.setPassword(passwordEncoder.encode(joinInDTO.getPassword()));

            //2. DB 저장
            userRepository.save(joinInDTO.toEntity());
        } catch (Exception e) {
            throw new RuntimeException("회원가입 오류 : " + e.getMessage());
        }

    }// 트랜젝션 종료시 - 더티체킹, DB 세션 종료 (OSIV=false)
}

