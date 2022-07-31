package com.study.dao;

import com.study.domain.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 菜品及套餐分类 Mapper 接口
 * </p>
 *
 * @author 代威浩
 * @since 2022-07-22
 */
@Mapper
public interface CategoryDao extends BaseMapper<Category> {

}
