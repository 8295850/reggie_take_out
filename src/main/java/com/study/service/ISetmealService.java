package com.study.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.common.R;
import com.study.domain.Setmeal;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 套餐 服务类
 * </p>
 *
 * @author 代威浩
 * @since 2022-07-22
 */
@Transactional
public interface ISetmealService extends IService<Setmeal> {
    /**
     * 分页显示
     * @param page
     * @param pageSize
     * @return
     */
    public R<Page> page(int page,int pageSize);

}
