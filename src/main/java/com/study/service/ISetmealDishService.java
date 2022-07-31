package com.study.service;

import com.study.domain.SetmealDish;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 套餐菜品关系 服务类
 * </p>
 *
 * @author 代威浩
 * @since 2022-07-22
 */
@Transactional
public interface ISetmealDishService extends IService<SetmealDish> {

}
