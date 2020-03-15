package com.example.libcocurrent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chengjie on 2020-03-01
 * Description:
 */
public class MyLock {
    // 测试转账的main方法
    public static void main(String[] args) throws InterruptedException {
        Account src = new Account(100);
        Account target = new Account(100);
        //CountDownLatch countDownLatch = new CountDownLatch(4);
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                src.transactionToTarget(1,target);
                //countDownLatch.countDown();
            }).start();
        }
       // countDownLatch.await();
        Thread.sleep(1000);
        System.out.println("src="+src.getBanalce() );
        System.out.println("target="+target.getBanalce() );
    }
    static class Account{ //账户类
        public Account(Integer banalce) {
            this.banalce = banalce;
        }
        private Integer banalce;
        public void transactionToTarget(Integer money,Account target){//转账方法
            Allocator.getInstance().apply(this,target);
            this.banalce -= money;
            target.setBanalce(target.getBanalce()+money);
            Allocator.getInstance().release(this,target);
        }
        public Integer getBanalce() {
            return banalce;
        }
        public void setBanalce(Integer banalce) {
            this.banalce = banalce;
        }
    }
    static class Allocator { //单例锁类
        private Allocator(){}
        private List<Account> locks = new ArrayList<>();
        public synchronized void apply(Account src,Account tag){
            System.out.println("111");
            while (locks.contains(src)||locks.contains(tag)) {
                System.out.println("222");
                try {
                    this.wait();
                    System.out.println("333");
                } catch (InterruptedException e) {
                   e.printStackTrace();
                }
            }
            locks.add(src);
            locks.add(tag);
        }
        public synchronized void release(Account src,Account tag){
            locks.remove(src);
            locks.remove(tag);
            this.notifyAll();
        }
        public static Allocator getInstance(){
            return AllocatorSingle.install;
        }
        static class AllocatorSingle{
            public static Allocator install = new Allocator();
        }
    }
}