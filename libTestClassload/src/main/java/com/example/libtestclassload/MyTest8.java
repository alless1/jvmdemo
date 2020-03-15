package com.example.libtestclassload;

/**
 * Created by chengjie on 2020-02-07
 * Description:
 * {{}}
 * new 对象{}是创建一个对象的内部类，可以重写类方法。
 * {{}}两个括号里面可以使用对象的字段和方法，执行位置是在构造函数代码之后。
 */
public class MyTest8 {
    public static void main(String[] args) {
/*        MyParent8 p =new MyParent8(9){
            {
                System.out.println("赋值a=2");
                a=2;
            }
        };*/
        new MyChild8(){
            {
                System.out.println("bbb");
            }
        };
        //System.out.println(p.a);
    }
}
class MyParent8{
    public int a = 5;
    public MyParent8(int x){
        a = x;
        System.out.println("构造函数打印a="+a);
    }
    public MyParent8(){
        System.out.println("MyParent8 construct");
    }
}

class MyChild8 extends MyParent8{
    public MyChild8(){
        super();
        System.out.println("MyChild8 construct");
    }
}
