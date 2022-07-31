package com.study.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.common.R;
import com.study.domain.Dish;
import com.study.domain.DishFlavor;
import com.study.domain.Employee;
import com.study.dto.DishDto;
import com.study.service.IDishFlavorService;
import com.study.service.IDishService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 菜品管理 前端控制器
 * </p>
 *
 * @author 代威浩
 * @since 2022-07-22
 */
@RestController
@RequestMapping("/dish")
@Slf4j
public class DishController {
    @Autowired
    private IDishService iDishService;
    @Autowired
    private IDishFlavorService iDishFlavorService;

    /**
     * 菜品展示
     *
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize) {
        //设置分页
        Page<Dish> dishPage = new Page<>(page, pageSize);
        //执行分页查询
        iDishService.page(dishPage);
        //返回分页数据
        return R.success(dishPage);
    }

    /**
     * 菜品及口味添加
     *
     * @param dishDto
     * @return
     */
    @PostMapping
    public R<String> save(@RequestBody DishDto dishDto) {


        return iDishService.saveWithFlavor(dishDto);

    }

    /**
     * 菜品及口味删除
     * @param ids
     * @return
     */
    @DeleteMapping
    public R<String> deleteDish(@RequestParam("ids") List<Long> ids) {

        for (Long id : ids) {
            iDishService.deleteWithFlavor(id);
        }

        return R.success("删除成功");
    }

    /**
     * 状态修改 启用或禁用
     * @param status
     * @param ids
     * @return
     */
    @PostMapping("/status/{status}")
    public R<String> status(@PathVariable int status,@RequestParam("ids") List<Long> ids){

        log.info("批量操作的dis==========={}",ids);
        //查询dish

        //设置状态

        //修改数据
        Dish dish = new Dish();
        dish.setStatus(status);
        for (Long id : ids) {
            LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
            dishLambdaQueryWrapper.eq(Dish::getId,id);
            iDishService.update(dish,dishLambdaQueryWrapper);
        }

        return R.success("状态修改完成");
    }

    /**
     * 数据回显
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R<DishDto> getById(@PathVariable Long id){
        //创建对象，用于返回重显
        DishDto dishDto = new DishDto();
        //查询数据
        Dish dish = iDishService.getById(id);
        //将数据拷贝到dishDto
        BeanUtils.copyProperties(dish,dishDto);
        //调用查询方法，查询当前id的菜品的口味
        List<DishFlavor> dishFlavors = iDishFlavorService.selectDishFlavor(id);
        //将口味添加到dishDto对象
        dishDto.setFlavors(dishFlavors);
        //返回对象
        return R.success(dishDto);
    }

    /**
     * 修改菜品
     * @param dishDto
     * @return
     */
    @PutMapping
    public R<String> update(@RequestBody DishDto dishDto) {

        return iDishService.updateWithFlavor(dishDto);

    }

}

