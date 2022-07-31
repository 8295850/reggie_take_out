package com.study.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.study.common.R;
import com.study.domain.Employee;
import com.study.dao.EmployeeDao;
import com.study.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;


/**
 * <p>
 * 员工信息 服务实现类
 * </p>
 *
 * @author 代威浩
 * @since 2022-07-18
 */
@Service
@Slf4j
public class EmployeeServiceImpl extends ServiceImpl<EmployeeDao, Employee> implements IEmployeeService {
    /**
     * 登录
     * @param request
     * @param employee
     * @return
     */
    @Override
    public R<Employee> login(HttpServletRequest request, Employee employee) {

        String password = employee.getPassword();
        //进行MD5加密
        employee.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));

        LambdaQueryWrapper<Employee> employeeLambdaQueryWrapper = new LambdaQueryWrapper<>();

        employeeLambdaQueryWrapper.eq(Employee::getUsername, employee.getUsername())
                .eq(Employee::getPassword, employee.getPassword());
        Employee emp = this.getOne(employeeLambdaQueryWrapper);



        //判断账号是否存在
        if ((emp == null)) {
            System.out.println("账号或密码错误");
            return R.error("账号或密码错误");
        }

        //查看账号是否禁用
        if (emp.getStatus() != 1) {
            System.out.println("账号已被禁用");
            return R.error("账号已被禁用");
        }
        Long thread = Thread.currentThread().getId();
        log.info("当前线程为：{}", thread);
        request.getSession().setAttribute("employee", emp.getId());
        return R.success(emp);
    }
}
