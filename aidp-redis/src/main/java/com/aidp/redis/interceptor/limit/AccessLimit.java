package com.aidp.redis.interceptor.limit;

import java.lang.annotation.*;

/**
 * 自定义注解
 */
@Inherited
@Documented
@Target({ElementType.FIELD,ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AccessLimit {
    //标识 指定sec时间段内的访问次数限制
    int limit() default 5;  
    //标识 时间段
    int sec() default 5;
}
