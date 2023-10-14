package com.logintest.logintest.service.member;

import com.logintest.logintest.domain.Member;
import com.logintest.logintest.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final PasswordEncoder passwordEncoder;

    private MemberMapper memMapper;

    @Override
    public boolean signUP(Member mem){
        String plain = mem.getPassword();
        String plainPassword = passwordEncoder.encode(plain);
        mem.setPassword(plainPassword);

        int cnt = memMapper.signUpInsert(mem);

        return cnt == 1;
    }

    @Override
    public Map<String, Object> checkId(String id) {

        Member mem = memMapper.selectByMemberId(id);
        boolean available = (mem == null);
        return Map.of("available", mem == null);
    }
}
