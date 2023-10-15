package com.logintest.logintest.controller.member;

import com.logintest.logintest.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    @PreAuthorize("isAnonymous()")
    public String loginForm(Member mem) {

        return "member/login";
    }
}
