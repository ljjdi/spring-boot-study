package com.jz.quick.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jz.quick.entity.Employee;
import com.jz.quick.pojo.EmployeeQuery;

public interface IEmployeeService extends IService<Employee> {
    IPage<Employee> queryPage(EmployeeQuery employeeQuery, Wrapper<Employee> wrappers);
}
