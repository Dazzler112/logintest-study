package com.logintest.logintest.service.member;

import com.logintest.logintest.domain.Member;

import java.util.Map;
import java.util.Objects;

public interface MemberService {
    public boolean signUP(Member mem);

    public Map<String, Object> checkId(String id);
}
