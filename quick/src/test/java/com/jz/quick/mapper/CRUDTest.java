package com.jz.quick.mapper;

import com.jz.quick.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CRUDTest {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Test
    public void testSave(){

        Employee employee = new Employee();
        employee.setUsername("xiaoming");
        employee.setPassword("123");
        employee.setAdmin(true);
        employee.setAge(17);
        employee.setEmail("xiaoming@qq.com");
        employee.setDeptId(1L);
        System.out.println(employeeMapper.insert(employee));
    }
}
