package com.jz.quick.servuce;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.jz.quick.entity.Employee;
import com.jz.quick.pojo.EmployeeQuery;
import com.jz.quick.service.IEmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class EmployeeServiceImpl {
    @Resource(name = "employeeServiceImpl")
    private IEmployeeService iEmployeeService;
    @Test
    public void testSelect(){
        LambdaQueryWrapper<Employee> wrapper = Wrappers.lambdaQuery();
        wrapper.select(Employee::getId,Employee::getId);
        iEmployeeService.list(wrapper);
    }
    @Test
    public void testSelect1(){

        EmployeeQuery employeeQuery = new EmployeeQuery();
        employeeQuery.setCurrentPage(2);
        employeeQuery.setPageSize(3);
        LambdaQueryWrapper<Employee> lambdaQueryWrapper = Wrappers.lambdaQuery();
        lambdaQueryWrapper.eq(Employee::getPassword,"123");
        // 调用自定义service分页方法
        IPage<Employee> pages =  iEmployeeService.queryPage(employeeQuery,lambdaQueryWrapper);
        System.out.println(pages.getRecords());
    }
}
