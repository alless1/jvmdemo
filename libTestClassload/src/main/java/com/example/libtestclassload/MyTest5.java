package com.example.libtestclassload;

import java.sql.SQLOutput;
import java.util.Random;

/**
 * Created by chengjie on 2020-02-05
 * Description:
 * 笔记不理解：
 * 当一个接口在初始化时，并不要求其父接口都完成了初始化
 * 只有在真正使用到父接口的时候（如引用接口中所定义的常量时），才会初始化
 * 个人理解：
 * 主要是因为接口的变量默认是public static final的，所以很正常有和类初始化的区别。
 */
public class MyTest5 {
    public static void main(String[] args) {
        //System.out.println(MyParent5.a);//删除MyParent5.class文件，一样可以运行。
        //System.out.println(MyChild5.b);//删除MyParent5.class,MyChild5.class，一样可以运行。
       // System.out.println(MyParent5.a1);//删除MyParent5.class文件，运行错误，提示找不到类。
        //System.out.println(MyChild5.a1);//删除MyChild5.class,运行错误，提示找不到类。
        //我的理解是看使用的接口的常量是否是运行期赋值的，如果是，就需要加载。但是笔记里的初始化？我感觉无法验证。

        System.out.println(MyChild5_1.a);//执行结果是51，并没有答应MyParent5_1中的变量中的字符串，说明类实现的接口没有执行初始化。
    }
}

interface MyParent5{
    int a = 5;
    int a1 = new Random().nextInt(10);
}

interface MyChild5 extends MyParent5{
    int b = 6;
}

interface MyParent5_1{
    Thread thread = new Thread(){
        {
            System.out.println("MyParent5_1 初始化赋值阶段执行");
        }
    };
}

class MyChild5_1 implements MyParent5_1{
    public static int a = 51;
}