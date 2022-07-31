package com.study.dao;

import com.study.domain.DishFlavor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 菜品口味关系表 Mapper 接口
 * </p>
 *
 * @author 代威浩
 * @since 2022-07-22
 */
@Mapper
public interface DishFlavorDao extends BaseMapper<DishFlavor> {
    @Delete("delete from dish_flavor where dish_id = #{id} ")
    void deleteByDishId(Long id);
}
