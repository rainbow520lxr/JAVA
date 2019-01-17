package com.java.ORM;

/*
使用反射读取注解的信息，模拟处理注解信息的流程
 */


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Orm {

    public static void mian(String[] args){
        try {
            //加载一个类
            Class clazz = Class.forName("com.java.ORM.Student");
            //获取类的所有有效注解
            Annotation[] annotations = clazz.getAnnotations();
            //
            for (Annotation a : annotations){  //遍历数组
                System.out.println(a);
            }
            //获得类的指定的注解
            Table t = (Table) clazz.getAnnotation(Table.class);
            System.out.println(t.value());
            //获得类属性的注解
            Field f =  clazz.getDeclaredField("studentName");
            com.java.ORM.Field field = f.getAnnotation(com.java.ORM.Field.class);
            System.out.println(field.columnName()+"__"+field.type()+"__"+field.length());

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
