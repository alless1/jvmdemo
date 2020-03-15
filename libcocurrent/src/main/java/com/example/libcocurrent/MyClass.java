package com.example.libcocurrent;

public class MyClass {

    private Object mObject =new Object();

    public void apply(){
        synchronized (mObject){
            //条件判断
            while (!pass()){
                try {
                    mObject.wait();//不符合条件，进入等待线程队列，释放锁资源
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //todo 执行逻辑代码

            //释放锁资源，唤醒其他等待线程
            mObject.notifyAll();
        }

    }

    public void release(){
        synchronized (mObject){
            mObject.notifyAll();
        }
    }


    private boolean pass(){
        return true;
    }

}
