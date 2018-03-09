package com.kn0527.cn.aop_android.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * auto：xkn on 2018/3/9 17:49
 * 用来标识性能监测
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)//存活、执行周期
public @interface BehaviorTrace {
    String value();
}
