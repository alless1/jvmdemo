package com.example.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chengjie on 2020-03-08
 * Description:
 */
public class MyTest1 {
    public static void main(String[] args) {
        List<MyTest1> list = new ArrayList<>();
        while (true) {
            list.add(new MyTest1());
            System.gc();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
