package com.example.libtestclassload;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Created by chengjie on 2020-02-23
 * Description:
 */
public class MyTest14 {
    public static void main(String[] args) {
        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = loader.iterator();
        while (iterator.hasNext()){
            Driver driver = iterator.next();
            System.out.println("driver:"+driver.getClass());
            System.out.println("classLoader:"+driver.getClass().getClassLoader());
        }
        System.out.println("contextClassLoader:"+Thread.currentThread().getContextClassLoader());
    }
}
