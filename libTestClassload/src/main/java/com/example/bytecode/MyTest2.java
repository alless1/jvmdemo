package com.example.bytecode;

/**
 * Created by chengjie on 2020-02-28
 * Description:
 */
public class MyTest2 {
    String str  = "welcome";
    private int x = 5;
    public static Integer in = 10;

    public static String sVar = "";



    private synchronized void setX(int x){
        int y = x;
        this.x = y;
    }
    private void test(String str){
        synchronized (str){
            System.out.println("hello world");
        }
    }
    private synchronized static void test2(){

    }

    public static void main(String[] args) {
        MyTest2 myTest2 = new MyTest2();
        myTest2.setX(8);
        in = 20;
    }
}
