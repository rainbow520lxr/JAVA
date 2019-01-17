package com.java.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.METHOD, ElementType.TYPE})    //意味着注解只能写在方法前面
@Retention(RetentionPolicy.RUNTIME)   //在运行能被反射，获取
public @interface TestAnnotation_1 {

    //当只有一个参数时定义为value
    String value() default "";

}
