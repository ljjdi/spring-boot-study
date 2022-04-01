package com.jz.quick.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jz.quick.entity.Employee;
import com.jz.quick.mapper.EmployeeMapper;
import com.jz.quick.pojo.EmployeeQuery;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

    @Override
    public IPage<Employee> queryPage(EmployeeQuery employeeQuery, Wrapper<Employee> wrapper) {
        IPage<Employee> employeeIPage = new Page<>(employeeQuery.getCurrentPage(),employeeQuery.getPageSize());

        return super.page(employeeIPage,wrapper);
    }
}
