package com.example.libtestclassload;

/**
 * Created by chengjie on 2020-02-06
 * Description:
 * 注意⚠️：静态变量的按顺序执行的准备和初始化！
 */
public class MyTest6 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        System.out.println(instance.getA());
        System.out.println(instance.getB());
        /**
         * 打印结果是
         * a++:1
         * b++:1
         * 1
         * 2
         */
        /**
         * 类的加载过程：
         * 首先准备阶段执行：
         * a=0,
         * sSingleton=null,
         * b=0
         * 然后初始化阶段执行：
         * a=0,
         * sSingleton = new Singleton(),执行构造方法，a++,b++(此时a=1,b=1),
         * b=2
         * 所以最终是 a=1,b=2
         */

    }
}

class Singleton{
    private  static int a ;
    private static Singleton sSingleton= new Singleton() ;
    private static int b = 2;
    //private  int c = 3;

    private Singleton(){
        a++;
        b++;
        System.out.println("a++:"+a);
        System.out.println("b++:"+b);
       // System.out.println("c:"+c);
    }

    public static Singleton getInstance(){
        return sSingleton;
    }


    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

}

