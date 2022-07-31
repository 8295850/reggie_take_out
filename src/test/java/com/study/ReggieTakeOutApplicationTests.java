package com.study;

import com.study.domain.Employee;
import com.study.service.IEmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class ReggieTakeOutApplicationTests {
    @Autowired
    private IEmployeeService iEmployeeService;

//    @Test
//    void contextLoads() {
//        Employee employee = new Employee();
//        employee.setUsername("123123");
//        Employee byName = iEmployeeService.getByName(employee);
//        System.out.println(byName);
//
//    }
    private String suffix = "123123.jpg";
    @Test
    public void updaImageName(){
        //通过UUID生成唯一文件名
        String filename = UUID.randomUUID() + suffix;
        System.out.println("新的文件名"+filename);
    }

}
