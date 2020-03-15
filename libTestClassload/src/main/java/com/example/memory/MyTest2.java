package com.example.memory;

/**
 * Created by chengjie on 2020-03-08
 * Description:
 */
public class MyTest2 {
    public Object lock1 = new Object();
    public Object lock2 = new Object();

    public void test1(){
        synchronized (lock1){
            System.out.println("test1");
            test2();
        }
    }

    public void test2(){
        synchronized (lock2){
            System.out.println("test2");
            test1();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyTest2 myTest2 = new MyTest2();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread1");
                myTest2.test1();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2");
                myTest2.test2();
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("end");
    }
}
