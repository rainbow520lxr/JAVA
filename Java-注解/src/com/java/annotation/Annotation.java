package com.java.annotation;

import java.util.ArrayList;

public class Annotation /*extend Object*/{         //所有类都继承了Object父类

    @Override   //重写覆盖超类的方法
    public String toString(){
        return  "";
    }

    @Deprecated
    public void test(){
        System.out.println("adasd");
    }

   // @SuppressWarnings()
    public void test1(){
   //     List list=new ArrayList();
    }

    public static void main(String[] args){

        Annotation a = new Annotation();
        a.test();     //被Deprecated修饰的方法调用会被打下划线，表示不建议使用


    }
}
