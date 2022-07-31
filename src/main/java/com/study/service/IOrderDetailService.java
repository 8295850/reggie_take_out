package com.study.service;

import com.study.domain.OrderDetail;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 订单明细表 服务类
 * </p>
 *
 * @author 代威浩
 * @since 2022-07-22
 */
@Transactional
public interface IOrderDetailService extends IService<OrderDetail> {

}
