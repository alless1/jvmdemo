package com.example.libtestclassload;

import java.util.UUID;

/**
 * Created by chengjie on 2020-02-05
 * Description:
 * 当一个常量的值并非编译期间可以确定的，那么其值就不会被放到调用类的常量池中，
 * 这时在程序运行时，会导致主动使用这个常量所在的类，显然会导致这个类被初始化。
 */
public class MyTest3 {
    public static void main(String[] args) {
        System.out.println(MyParent3.str);
        /**
         * 输出结果：
         * MyParent3 static block
         * 75a6b18d-7efd-4885-8fd8-ba37b813393e
         */

    }
}
class MyParent3{

    public static final String str = UUID.randomUUID().toString();
    static {
        System.out.println("MyParent3 static block");
    }
}
