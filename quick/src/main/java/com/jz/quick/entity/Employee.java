package com.jz.quick.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Employee {
    private Long id;
    private String username;
    private String password;
    private String email;
    private int age;
    private Boolean admin;
    private Long deptId;
}
