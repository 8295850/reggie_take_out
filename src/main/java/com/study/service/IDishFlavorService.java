package com.study.service;

import com.study.domain.DishFlavor;
import com.baomidou.mybatisplus.extension.service.IService;
import com.study.dto.DishDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 菜品口味关系表 服务类
 * </p>
 *
 * @author 代威浩
 * @since 2022-07-22
 */
@Transactional
public interface IDishFlavorService extends IService<DishFlavor> {
    /**
     * 根据菜品添加口味
     * @param dishDto
     * @param dishId
     * @return
     */
    public Boolean saveDishFlavor(DishDto dishDto,Long dishId);

    /**
     * 根据菜品删除口味
     * @param dishId
     * @return
     */
    public Boolean deleteDishFlavor(Long dishId);

    /**
     * 根据菜品查找口味
     */
    public List<DishFlavor> selectDishFlavor(Long dishId);

    /**
     * 修改根据口味
     * @param dishDto
     * @return
     */
    public Boolean updateDishFlavor(DishDto dishDto);

}
