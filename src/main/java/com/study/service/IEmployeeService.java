package com.study.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.study.common.R;
import com.study.domain.Employee;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 员工信息 服务类
 * </p>
 *
 * @author 代威浩
 * @since 2022-07-18
 */
@Transactional
public interface IEmployeeService extends IService<Employee> {


    public R<Employee> login(HttpServletRequest request,Employee employee);

}
