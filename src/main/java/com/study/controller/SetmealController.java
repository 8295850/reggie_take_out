package com.study.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.common.R;
import com.study.domain.Setmeal;
import com.study.service.ISetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 套餐 前端控制器
 * </p>
 *
 * @author 代威浩
 * @since 2022-07-22
 */
@RestController
@RequestMapping("/setmeal")
public class SetmealController {
    @Autowired
    private ISetmealService iSetmealService;

    @GetMapping("/page")
    public R<Page> page(@RequestParam("page") int page, @RequestParam int pageSize) {

       return  iSetmealService.page(page,pageSize);

    }


}

