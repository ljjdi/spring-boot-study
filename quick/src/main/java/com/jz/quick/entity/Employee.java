package com.jz.quick.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@TableName("employee")
public class Employee {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    @TableField(value = "username")
    private String name;
    private String password;
    private String email;
    private int age;
    @TableField(value = "username",exist = false)
    private Boolean admin;
    private Long deptId;
}
