package com.study.config;


import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis plus 配置类
 */
@Slf4j
@Configuration
public class MpConfig {
    /**
     * 创建MybatisPlus拦截器
     */
    @Bean
    public MybatisPlusInterceptor pageInterceptor(){
        log.info("mp 拦截器...");
        //定义拦截器
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
         //添加分页拦截器
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        //添加乐观锁拦截器
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return interceptor;

    }
}
