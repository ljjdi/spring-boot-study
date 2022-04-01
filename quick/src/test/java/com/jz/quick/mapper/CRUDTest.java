package com.jz.quick.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jz.quick.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class CRUDTest {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Test
    public void testSave(){

        Employee employee = new Employee();
        employee.setName("xiaoluo");
        employee.setPassword("123");
        employee.setAdmin(true);
        employee.setAge(17);
        employee.setEmail("xiaoming@qq.com");
        employee.setDeptId(1L);
        System.out.println(employeeMapper.insert(employee));
//        System.out.println(employee.getId());
    }
    @Test
    public void testDelete1(){
        int i = employeeMapper.deleteById(1509713593232703496L);
        Assert.isTrue(i == 1,"失败");
    }
    @Test
    public void testDelete2(){
        int i = employeeMapper.deleteBatchIds(Arrays.asList("1509713593232703494","1509713593232703495"));
        Assert.isTrue(i == 2,"失败");

    }
    @Test
    public void testDelete3(){
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.eq("id","1509713593232703492");
        wrapper.eq("username","xiaoluo");
        testResult(employeeMapper.delete(wrapper),1);
    }
    private void testResult(int i,int e){
        Assert.isTrue(i == e,"失败");
    }
    @Test
    public void testUpdate1(){
        Employee employee = new Employee();
//        employee.setId(150946905548643134L);
        employee.setName("1");
        employee.setPassword("123");
        employee.setAdmin(true);
        employee.setAge(17);
        employee.setEmail("daming@qq.com");
//        employee.setDeptId(1L);
        testResult(employeeMapper.updateById(employee),1);
    }
    @Test
    public void testUpdate2(){
        UpdateWrapper<Employee> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id","1509469055486431234");
        updateWrapper.eq("username","1");
        updateWrapper.set("password","000");
        testResult(employeeMapper.update(null,updateWrapper),1);
    }
    @Test
    public void testUpdate3(){
        Employee employee = new Employee();
        employee.setPassword("xiaoluo1");
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.eq("id","1509469055486431234");
        wrapper.eq("username","1");
        int i = employeeMapper.update(employee,wrapper);
        testResult(i,1);
    }
    @Test
    public void testSelect1(){
        Employee employee = employeeMapper.selectById("1509469055486431234");
        Assert.isTrue(employee != null,"失败");
    }
    @Test
    public void testSelect2(){
        List<Employee> employees = employeeMapper.selectBatchIds(Arrays.asList(150946905548643124L,1509469372630339586L));
        Assert.isTrue(employees.size() == 2,"fail");
    }
    @Test
    public void testSelect3(){
        Map map = new HashMap<String,Object>();
        map.put("id",150946905548643124L);
        map.put("username","xiaoluo");
        List<Employee> employees = employeeMapper.selectByMap(map);

    }
    @Test
    public void testSelect4(){
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.eq("password","123");
        int i = employeeMapper.selectCount(wrapper).intValue();
        testResult(i ,5);
    }
    @Test
    public void testSelect5(){
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.eq("password","123");
        System.out.println(employeeMapper.selectList(wrapper));
    }
    @Test
    public void testSelect6(){
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        List<Map<String,Object>> list = employeeMapper.selectMaps(wrapper);
        list.forEach(System.out::println);
    }
    @Test
    public void testSelect7(){
        QueryWrapper<Employee> wrapper= new QueryWrapper<>();
        IPage<Employee> page = new Page<>(3,2);
        employeeMapper.selectPage(page,wrapper);
        System.out.println(page);
    }
    @Test
    public void testSelect8(){
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        Map<String,Object> map = new HashMap<>();
        map.put("password",123);
        map.put("email",null);
        wrapper.allEq(false,map,false);
        List<Employee> employees = employeeMapper.selectList(wrapper);
        System.out.println(employees);
    }
    @Test
    public void testSelect9(){
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.ne("password",null);
        employeeMapper.selectList(wrapper);
    }
    @Test
    public void testSelect10(){
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
//        wrapper.notBetween("age",1,17);
//        wrapper.notIn(true,"username","xiaoluo","2");
//        wrapper.notInSql("id","select id from employee where age > 1");
//        wrapper.groupBy("dept_id","username").select("username","count(1) count")
//                .having("count > {0} and count < {1}",1,5);
//        wrapper.orderBy(true,true,"age","id");
//        wrapper.like("username","xiao")
//                .and(w -> w.ge("age",17)
//                        .or()
//                        .le("age",1));
//        wrapper.apply("age > {0}",1);
//        wrapper.exists("select id from employee where age = 0");

        employeeMapper.selectList(wrapper);

    }
    @Test
    public void testSelect11() {
        LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(Employee::getId,Employee::getAge).eq(Employee::getAge,0);
        employeeMapper.selectList(wrapper);
    }
    @Test
    public void testXMLSQL(){
        employeeMapper.listUseXml();
    }
    @Test
    public void testAnnotation(){
        employeeMapper.listUseAnnotation();
    }
}
