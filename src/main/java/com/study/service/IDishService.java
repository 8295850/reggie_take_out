package com.study.service;

import com.study.common.R;
import com.study.domain.Dish;
import com.baomidou.mybatisplus.extension.service.IService;
import com.study.dto.DishDto;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 菜品管理 服务类
 * </p>
 * @author 代威浩
 *
 * @since 2022-07-22
 */
@Transactional
public interface IDishService extends IService<Dish> {
    /**
     * 添加菜品
     * @param dishDto
     * @return
     */
    public R<String> saveWithFlavor(DishDto dishDto);

    /**
     * 删除菜品
     * @param id
     * @return
     */
    public R<String> deleteWithFlavor(Long id);

    /**
     * 修改菜品
     * @param dishDto
     * @return
     */
    public R<String> updateWithFlavor(DishDto dishDto);

}
