package com.study.service.impl;

import com.study.domain.Orders;
import com.study.dao.OrdersDao;
import com.study.service.IOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author 代威浩
 * @since 2022-07-22
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersDao, Orders> implements IOrdersService {

}
