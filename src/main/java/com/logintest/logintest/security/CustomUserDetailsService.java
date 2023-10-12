package com.logintest.logintest.security;

import com.logintest.logintest.domain.Member;
import com.logintest.logintest.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = mapper.selectByMemberId(username);

        if(member == null) {
            new UsernameNotFoundException(username + "해당 회원 조회 불가");
        }

        UserDetails user = User.builder()
                .username(member.getId())
                .password(member.getPassword())
                .authorities(member.getAuthority().stream().map(SimpleGrantedAuthority::new).toList())
                .build();

        return user;
    }
}
