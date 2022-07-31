package com.study.common;

/**
 * 基于ThreadLocal封装工具类，将用户id保存到线程中
 */
public  class BaseContext {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();
    //将id添加到线程中
    public static void setCurrentId(Long id){
        threadLocal.set(id);
    }
    //将id取出
    public static Long getCurrentId(){
       return  threadLocal.get();
    }

}
