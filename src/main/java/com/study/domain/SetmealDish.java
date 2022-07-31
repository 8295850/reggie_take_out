package com.study.domain;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 套餐菜品关系
 * </p>
 *
 * @author 代威浩
 * @since 2022-07-22
 */
@Data
/**
 * @EqualsAndHashCode(callSuper = false)
 *  是否重写父类 equals方法
 *  false：比较对象之间的值
 *  true：不重写
 */
@EqualsAndHashCode(callSuper = false)
public class SetmealDish implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 套餐id 
     */
    private String setmealId;

    /**
     * 菜品id
     */
    private String dishId;

    /**
     * 菜品名称 （冗余字段）
     */
    private String name;

    /**
     * 菜品原价（冗余字段）
     */
    private BigDecimal price;

    /**
     * 份数
     */
    private Integer copies;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建人
     */
    private Long createUser;

    /**
     * 修改人
     */
    private Long updateUser;

    /**
     * 是否删除
     */
    private Integer isDeleted;


}
