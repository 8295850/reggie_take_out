package com.study.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.study.common.BusinessException;
import com.study.common.R;
import com.study.domain.Category;
import com.study.dao.CategoryDao;
import com.study.domain.Dish;
import com.study.domain.Setmeal;
import com.study.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.service.IDishService;
import com.study.service.ISetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>
 * 菜品及套餐分类 服务实现类
 * </p>
 *
 * @author 代威浩
 * @since 2022-07-22
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, Category> implements ICategoryService {
    @Autowired
    private IDishService iDishService;
    @Autowired
    private ISetmealService iSetmealService;

    /**
     * 删除分类
     * @param ids
     * @return
     */
    public Boolean remove(Long ids) {

        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.eq(Dish::getCategoryId, ids);
        int count = iDishService.count(dishLambdaQueryWrapper);

        if (count > 0) {
//            当前菜品分类下有菜品，无法进行删除
            throw new BusinessException("当前分类下有菜品，无法进行删除");
        }

        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId, ids);
        count = iSetmealService.count(setmealLambdaQueryWrapper);

        if (count > 0) {
//            当前菜品分类下有菜品，无法进行删除
            throw new BusinessException("当前分类下有套餐，无法进行删除");
        }


//        boolean deleteFlag = iCategoryService.removeById(ids);
//        return deleteFlag ? R.success("删除成功"):R.error("删除失败");

        return super.removeById(ids);

    }


}
