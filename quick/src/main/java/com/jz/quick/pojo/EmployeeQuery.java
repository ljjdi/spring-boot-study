package com.jz.quick.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeQuery {
    private Integer currentPage = 1;
    private Integer pageSize = 1;
}
