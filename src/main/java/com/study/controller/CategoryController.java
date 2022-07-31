package com.study.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.common.R;
import com.study.domain.Category;
import com.study.service.ICategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 菜品及套餐分类 前端控制器
 * </p>
 *
 * @author 代威浩
 * @since 2022-07-22
 */
@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;


    /**
     * 分页查询菜品
     *
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/page")
    public R<Page> getAll(int page, int pageSize) {

        log.info("page{},pageSize{}", page, pageSize);

        //分页
        Page<Category> categoryPage = new Page(page, pageSize);

        //排序条件
        LambdaQueryWrapper<Category> categoryLambdaQueryWrapper = new LambdaQueryWrapper();
        categoryLambdaQueryWrapper.orderByAsc(Category::getSort);
        //分页查询
        iCategoryService.page(categoryPage, categoryLambdaQueryWrapper);
        //将分页查询的 总页数，共多少页以及数据等返回给前端
        return R.success(categoryPage);
    }

    /**
     * 添加菜品
     *
     * @param category
     * @return
     */
    @PostMapping
    public R<String> add(@RequestBody Category category) {
        //执行添加
        boolean saveFlag = iCategoryService.save(category);
        return saveFlag ? R.success("添加成功") : R.error("添加失败");
    }

    /**
     * 修改菜品
     *
     * @param category
     * @return
     */
    @PutMapping
    public R<String> update(@RequestBody Category category) {
        boolean updateFlag = iCategoryService.updateById(category);
        return updateFlag ? R.success("添加成功") : R.error("添加失败");
    }

    /**
     * 删除菜品
     *
     * @param ids
     * @return
     */
    @DeleteMapping
    public R<String> delete(Long ids) {
        log.info("需要删除数据的id：{}", ids);
        Boolean removeFlag = iCategoryService.remove(ids);
        return removeFlag ? R.success("删除成功") : R.error("删除失败");

    }

    /**
     * 回显type分类
     * @param type
     * @return
     */
    @GetMapping("/list")
    public R<List<Category>> List(@RequestParam("type")int type){
        LambdaQueryWrapper<Category> categoryLambdaQueryWrapper = new LambdaQueryWrapper<>();
        //条件
        categoryLambdaQueryWrapper.eq(Category::getType,type).orderByAsc(Category::getSort);
        List<Category> list = iCategoryService.list(categoryLambdaQueryWrapper);

        return R.success(list);
    }
}
