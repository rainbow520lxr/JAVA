package com.java.ORM;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.FIELD})    //修饰的是属性
@Retention(RetentionPolicy.RUNTIME)
public @interface Field {
    String columnName();
    String type();
    int length();

}
