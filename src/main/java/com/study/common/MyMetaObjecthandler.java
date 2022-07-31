package com.study.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * mybatis plus提供的公共字段自动填充
 * 实体类属性需要配置做什么操作时进行填充 如：@TableField(fill = FieldFill.INSERT)，代表添加时进行填充
 * 在执行完controller后会执行此类方法（根据修改或添加操作进行之下下列方法）
 */
@Component
@Slf4j
public class MyMetaObjecthandler implements MetaObjectHandler {
    /**
     * 添加时
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        Long  thread = Thread.currentThread().getId();
        log.info("当前线程为：{}", thread);
        log.info("当前用户id{}",BaseContext.getCurrentId());
        //设置创建时间
        metaObject.setValue("createTime", LocalDateTime.now());
        //设置创建人id
        metaObject.setValue("createUser", BaseContext.getCurrentId());
        //设置修改时间
        metaObject.setValue("updateTime", LocalDateTime.now());
        //设置修改人id
        metaObject.setValue("updateUser", BaseContext.getCurrentId());
    }

    /**
     * 修改时
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        Long  thread = Thread.currentThread().getId();
        log.info("当前线程为：{}", thread);
        log.info("当前用户id{}",BaseContext.getCurrentId());
        //设置修改时间
        metaObject.setValue("updateTime", LocalDateTime.now());
        //设置修改人id
        metaObject.setValue("updateUser", BaseContext.getCurrentId());


    }
}
