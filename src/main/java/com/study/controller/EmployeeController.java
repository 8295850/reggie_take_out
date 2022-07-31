package com.study.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.common.BaseContext;
import com.study.common.R;
import com.study.domain.Employee;
import com.study.service.IEmployeeService;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 员工信息 前端控制器
 * </p>
 *
 * @author 代威浩
 * @since 2022-07-18
 */
@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    /**
     * 用户登录
     *
     * @param request  页面请求
     * @param employee 页面json
     * @return
     */
    @PostMapping("/login")
    public R<Employee> login(HttpServletRequest request, @RequestBody Employee employee) {

       return  iEmployeeService.login(request,employee);

    }

    /**
     * 退出
     *
     * @param request 页面请求
     * @return
     */
    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request) {
        request.getSession().removeAttribute("employee");
        return R.success("退出成功");
    }

    /**
     * 用户添加
     *
     * @param request  页面请求
     * @param employee json
     * @return
     */
    @PostMapping
    public R<String> add(HttpServletRequest request, @RequestBody Employee employee) {
        //设置默认密码为123456，并进行MD5加密
        employee.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));

        boolean save = iEmployeeService.save(employee);

        return save ? R.success("添加成功") : R.error("添加失败,用户名已存在");
    }

    /**
     * 查询全部
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize, String name) {
        /**
         * 参数1：从第几页开始
         * 参数2：每页显示多少
         */
        Page<Employee> employeePage = new Page(page, pageSize);
        LambdaQueryWrapper<Employee> employeeLambdaQueryWrapper = new LambdaQueryWrapper();
        // 如果name不等于空，就执行表达式
        employeeLambdaQueryWrapper.like(StringUtils.isNotEmpty(name), Employee::getName, name)
                .orderByAsc(Employee::getId);
        iEmployeeService.page(employeePage, employeeLambdaQueryWrapper);

        return R.success(employeePage);
    }

    @GetMapping("/{id}")
    public R<Employee> getByid(@PathVariable Long id) {
        log.info("当前id{}", id);
        LambdaQueryWrapper<Employee> employeeLambdaQueryWrapper = new LambdaQueryWrapper<>();
        employeeLambdaQueryWrapper.eq(Employee::getId, id);
        Employee one = iEmployeeService.getOne(employeeLambdaQueryWrapper);
        return R.success(one);
    }

    @PutMapping
    public R<String> getByid(HttpServletRequest request, @RequestBody Employee employee) {
        Long empId = (Long) request.getSession().getAttribute("employee");
       /* employee.setUpdateTime(LocalDateTime.now());
        employee.setUpdateUser(empId);*/
        boolean flag = iEmployeeService.updateById(employee);

        return flag ? R.success("修改成功") : R.error("请重新尝试");
    }


}

