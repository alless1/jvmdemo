package com.example.libtestclassload;

import java.lang.reflect.Method;

/**
 * Created by chengjie on 2020-02-22
 * Description:
 */
public class MyTest11 {
    public static void main(String[] args) throws Exception {
        MyClassloader2 loader1 = new MyClassloader2();
        MyClassloader2 loader2 = new MyClassloader2();
        loader1.setPath("/Users/chengjie/Desktop/");
        loader2.setPath("/Users/chengjie/Desktop/");
        Class<?> aClass1 = loader1.loadClass("com.example.libtestclassload.MyPerson");
        Class<?> aClass2 = loader2.loadClass("com.example.libtestclassload.MyPerson");
        Object instance1 = aClass1.newInstance();
        Object instance2 = aClass2.newInstance();
        Method method1 = aClass1.getMethod("setMyPerson", Object.class);
        method1.invoke(instance1, instance2);
    }
}
