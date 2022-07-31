package com.study.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.common.R;
import com.study.domain.Setmeal;
import com.study.dao.SetmealDao;
import com.study.service.ISetmealService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 套餐 服务实现类
 * </p>
 *
 * @author 代威浩
 * @since 2022-07-22
 */
@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealDao, Setmeal> implements ISetmealService {
    /**
     * 分页显示
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public R<Page> page(int page, int pageSize) {
        Page<Setmeal> setmealPage = new Page<>(page, pageSize);

        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.orderByDesc(Setmeal::getCode);

        this.page(setmealPage, setmealLambdaQueryWrapper);

        return R.success(setmealPage);
    }
}
