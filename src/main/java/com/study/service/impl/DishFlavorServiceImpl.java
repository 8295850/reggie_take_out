package com.study.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.study.common.BusinessException;
import com.study.domain.DishFlavor;
import com.study.dao.DishFlavorDao;
import com.study.dto.DishDto;
import com.study.service.IDishFlavorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜品口味关系表 服务实现类
 * </p>
 *
 * @author 代威浩
 * @since 2022-07-22
 */
@Service
@Slf4j
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorDao, DishFlavor> implements IDishFlavorService {
    @Autowired
    private DishFlavorDao dishFlavorDao;

    /**
     * 添加口味
     *
     * @param dishDto
     * @return
     */
    @Override
    public Boolean saveDishFlavor(DishDto dishDto, Long dishId) {
        List<DishFlavor> flavors = dishDto.getFlavors();
        //存储口味name,为判断口味是否重复
        Map<String, Integer> map = new HashMap();
        //遍历口味
        for (DishFlavor dishFlavor : flavors) {
            //为口味绑定菜品id
            dishFlavor.setDishId(dishId);
            //判断口味选择项是否重复
            if (map.containsKey(dishFlavor.getName())) {
                //不使用异常，则无法触发事务，上方操作会生效！
                throw new BusinessException("口味选择重复!");
            } else {
                //如果这个口味没有，则添加到集合
                map.put(dishFlavor.getName(), 1);
            }
        }

        return this.saveBatch(flavors);
    }

    /**
     * 删除口味
     *
     * @param dishId
     * @return
     */
    @Override
    public Boolean deleteDishFlavor(Long dishId) {

        LambdaQueryWrapper<DishFlavor> dishFlavorLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishFlavorLambdaQueryWrapper.eq(DishFlavor::getDishId, dishId);

        return this.remove(dishFlavorLambdaQueryWrapper);
    }

    /**
     * 查找口味
     *
     * @param dishId
     * @return
     */
    @Override
    public List<DishFlavor> selectDishFlavor(Long dishId) {
        LambdaQueryWrapper<DishFlavor> dishFlavorLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishFlavorLambdaQueryWrapper.eq(DishFlavor::getDishId, dishId);

        return dishFlavorDao.selectList(dishFlavorLambdaQueryWrapper);
    }

    /**
     * 修改口味
     *
     * @param dishDto
     * @return
     */
    @Override
    public Boolean updateDishFlavor(DishDto dishDto) {


        //删除表中现有的口味
        dishFlavorDao.deleteByDishId(dishDto.getId());


        List<DishFlavor> flavors = dishDto.getFlavors();
        //存储口味name,为判断口味是否重复
        Map<String, Integer> map = new HashMap();
        //遍历口味
        for (DishFlavor dishFlavor : flavors) {

            //为口味绑定菜品id
            dishFlavor.setDishId(dishDto.getId());
            //判断口味选择项是否重复
            if (map.containsKey(dishFlavor.getName())) {
                //不使用异常，则无法触发事务，上方操作会生效！
                throw new BusinessException("口味选择重复!");
            } else {
                //如果这个口味没有，则添加到集合
                map.put(dishFlavor.getName(), 1);
            }
        }
        return this.saveBatch(flavors);






    }
}
