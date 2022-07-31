package com.study.service;

import com.study.domain.ShoppingCart;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 购物车 服务类
 * </p>
 *
 * @author 代威浩
 * @since 2022-07-22
 */
@Transactional
public interface IShoppingCartService extends IService<ShoppingCart> {

}
