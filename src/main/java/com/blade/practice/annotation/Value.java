package com.blade.practice.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * TODO:
 *
 * @author chenjiangxin
 * @date 2018/11/23 16:08
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface Value {
    String value() default "";
}
