package com.example.libtestclassload;

/**
 * 1、对于静态字段(方法)类说，只有直接定义了该字段的类才会被初始化。
 * 2、当一个类在初始化时，要求其父类全部都已经初始化完毕。
 * -XX:+TraceClassLoading 用于追踪类的加载信息，并打印出来。
 * -XX:+TraceClassUnloading 追踪类的卸载信息。
 * jvm参数设置的三种情况
 * -XX:+<option>，表示开启option选项
 * -XX:-<option>，表示关闭option选项
 * -XX:<option>=<value>，表示将option选项的值设置为value
 */
public class MyTest1 {
    public static void main(String[] args) {
        //执行语句1，使用子类引用父类的静态变量，仅初始化父类。（子类有加载）
        System.out.println(Child1.parentName);
        /**
         * 输出结果1：
         * Parent1 static block
         * Parent1
         */

        //执行语句2，使用子类的静态变量，初始化父类和子类。
        //System.out.println(Child1.childName);
        /**
         * 输出结果2：
         * Parent1 static block
         * Child1 static block
         * Child1
         */
        //执行语句3，使用子类引用父类的静态方法，仅初始化父类。
        //Child1.doSomething();
        /**
         * 输出结果3：
         * Parent1 static block
         * doSomething
         */
    }

}

class Parent1{
    public static String parentName = "Parent1";
    static {
        System.out.println("Parent1 static block ");
    }
   public static void doSomething(){
        System.out.println("doSomething");
    }
}

class Child1 extends Parent1{
    public static String childName = "Child1";
    static {
        System.out.println("Child1 static block");
    }

}
