package com.study.common;

import java.lang.reflect.Field;

/**
 * 对象工具类
 */
public class ObjectUtil {
    /**
     * 判断对象属性是不是有空值
     * @param object
     * @return
     */
    public static boolean isFieldNull(Object object) {
        boolean flag = false;

        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {

            //排除id属性
            if (!(field.getName().equals("id"))) {

                //设置属性是可以访问的(私有的也可以)
                field.setAccessible(true);
                Object value = null;
                try {
                    value = field.get(object);
                    // 只要有1个属性为空,那么就不是所有的属性都有数据
                    if (value == null) {
                        flag = true;
                        break;
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return flag;
    }

}
