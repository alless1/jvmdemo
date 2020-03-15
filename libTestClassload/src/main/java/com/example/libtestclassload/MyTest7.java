package com.example.libtestclassload;

/**
 * Created by chengjie on 2020-02-06
 * Description:
 * 静态变量的声明语句和静态代码块都被看作类的初始化语句，
 * 按顺序执行。
 */
public class MyTest7 {
    public static void main(String[] args) {
        System.out.println(Parent7.b);//打印结果： 1
    }
}

class Parent7{
    public static int a;
    static {
        b = 2;
    }
    public static int b =1;

}
