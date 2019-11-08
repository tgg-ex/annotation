package com.zj.demo;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Info {

    //校验失败报错信息
    String value();

    //最大值
    String max() default "";

    //最小值
    String min();
}
