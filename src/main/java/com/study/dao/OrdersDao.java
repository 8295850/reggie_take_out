package com.study.dao;

import com.study.domain.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author 代威浩
 * @since 2022-07-22
 */
@Mapper
public interface OrdersDao extends BaseMapper<Orders> {

}
