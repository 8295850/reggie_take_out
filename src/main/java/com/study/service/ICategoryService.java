package com.study.service;

import com.study.domain.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 菜品及套餐分类 服务类
 * </p>
 *
 * @author 代威浩
 * @since 2022-07-22
 */
@Transactional
public interface ICategoryService extends IService<Category> {

    public Boolean remove(Long ids);

}
