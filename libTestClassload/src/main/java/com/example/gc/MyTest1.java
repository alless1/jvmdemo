package com.example.gc;

/**
 * Created by chengjie on 2020-03-26
 * Description:
 * <p>
 * -verbose:gc  //输出gc日志
 * -Xms20M      //堆起始大小20m
 * -Xmx20M      //堆最大容量20m
 * -Xmn10M      //新生代大小10m
 * -XX:+PrintGCDetails  //打印GC详情
 * -XX:SurvivorRatio=8  //新生代eden空间占比80%，from survivor和to survivor平分20%
 */
public class MyTest1 {
    public static void main(String[] args) {
        int size = 1024 * 1024;
        byte[] myAlloc1 = new byte[2 * size];
        byte[] myAlloc2 = new byte[2 * size];
        byte[] myAlloc3 = new byte[3 * size];
        System.out.println("hello world");
    }
}