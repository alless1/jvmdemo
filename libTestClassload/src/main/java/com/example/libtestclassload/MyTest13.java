package com.example.libtestclassload;

/**
 * Created by chengjie on 2020-02-23
 * Description:
 */
public class MyTest13 implements Runnable {
    private Thread mThread;
    public MyTest13(){
        mThread = new Thread(this);
        mThread.start();
    }
    @Override
    public void run() {
        ClassLoader contextClassLoader = this.mThread.getContextClassLoader();
        this.mThread.setContextClassLoader(contextClassLoader);
        System.out.println(contextClassLoader);

        System.out.println(contextClassLoader.getParent());
    }

    public static void main(String[] args) {
        new MyTest13();
    }
}
