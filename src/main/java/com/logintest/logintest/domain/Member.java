package com.logintest.logintest.domain;

import lombok.Data;

import java.util.List;

@Data
public class Member {
    private String id;
    private String password;
    private String name;
    private Integer old;
    private String gender;
    private String phoneNumber;
    private String email;
    private String memberType;
    private String address;
    private Integer isActive;
    private List<String> authority;
}
