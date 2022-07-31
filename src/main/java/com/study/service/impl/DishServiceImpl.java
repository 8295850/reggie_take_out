package com.study.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.study.common.BusinessException;
import com.study.common.R;
import com.study.domain.Dish;
import com.study.dao.DishDao;
import com.study.domain.DishFlavor;
import com.study.dto.DishDto;
import com.study.service.IDishFlavorService;
import com.study.service.IDishService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 菜品管理 服务实现类
 * </p>
 *
 * @author 代威浩
 * @since 2022-07-22
 */
@Service
public class DishServiceImpl extends ServiceImpl<DishDao, Dish> implements IDishService {
    @Autowired
    private IDishFlavorService iDishFlavorService;



    /**
     * 添加菜品和口味
     * @param dishDto
     * @return
     */
    @Override
    public R<String> saveWithFlavor(DishDto dishDto) {
        this.save(dishDto);
        Long dishId = dishDto.getId();
        //调用添加口味方法
        iDishFlavorService.saveDishFlavor(dishDto,dishId);

        return R.success("添加成功");


    }

    /**
     * 删除菜品和口味
     * @param id
     * @return
     */
    @Override
    public R<String> deleteWithFlavor(Long id) {

        this.removeById(id);
        //调用删除口味方法
        iDishFlavorService.deleteDishFlavor(id);
        return R.success("删除完成");
    }

    /**
     * 修改菜品和口味
     * @param dishDto
     * @return
     */
    @Override
    public R<String> updateWithFlavor(DishDto dishDto) {

        this.updateById(dishDto);

        //调用修改口味方法
        iDishFlavorService.updateDishFlavor(dishDto);

        return R.success("修改成功");


    }
}
