package com.java.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//注解的值可以在注解内默认值，也可以在注解时进行赋值


@Target(value = {ElementType.METHOD, ElementType.TYPE})    //意味着注解只能写在方法前面
@Retention(RetentionPolicy.RUNTIME)   //在运行能被反射，获取
//注解里面加入内容
public @interface TestAnnotation {
    //注解的语法格式
    //定义一个变量格式  变量类型名  变量名()  default "" 默认值
    String studentName() default "";
    int studentId() default 0;
    int id() default -1;  //表示不存在   String indexOf("abc") =-1时表示不存在
    //注意：
    //注解元素必须要有值。我们定义注解元素时，经常使用空字符串、0作为默认值
    //也经常使用负数（比如：-1）表示不存在的含义


    //定义数组
    String[] school() default {"ni", "hao"};

}
