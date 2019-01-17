package com.java.ORM;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.TYPE})   //修饰的是类
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
    String value() default "";

}
