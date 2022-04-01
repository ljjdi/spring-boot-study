package com.jz.quick.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jz.quick.entity.Employee;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EmployeeMapper  extends BaseMapper<Employee> {
    List<Employee> listUseXml();
    @Select(value = "select *  from employee")
    List<Employee> listUseAnnotation();
}
