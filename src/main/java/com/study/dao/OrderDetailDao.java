package com.study.dao;

import com.study.domain.OrderDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 订单明细表 Mapper 接口
 * </p>
 *
 * @author 代威浩
 * @since 2022-07-22
 */
@Mapper
public interface OrderDetailDao extends BaseMapper<OrderDetail> {

}
