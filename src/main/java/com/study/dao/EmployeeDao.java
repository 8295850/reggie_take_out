package com.study.dao;

import com.study.domain.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 * 员工信息 Mapper 接口
 * </p>
 *
 * @author 代威浩
 * @since 2022-07-18
 */
@Mapper
public interface EmployeeDao extends BaseMapper<Employee> {
//    @Update("update employee set name = #{name},username = #{username},phone = #{phone},sex = #{sex},id_number = #{idNumber} where id = #{id}")
//    int updateEmployee(Employee employee);
}
