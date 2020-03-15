package com.example.libtestclassload;

import java.io.File;
import java.util.StringTokenizer;

import sun.misc.Launcher;

/**
 * Created by chengjie on 2020-02-23
 * Description:
 */
public class MyTest12 {
    public static void main(String[] args) {
        //System.out.println(System.getProperty("java.system.class.loader"));
        //System.out.println(System.getProperty("java.ext.dirs"));
        //自定义系统类加载器
        //java -Djava.system.class.loader=com.example.libtestclassload.MyClassloader2 com.example.libtestclassload.MyTest12
         System.out.println(ClassLoader.getSystemClassLoader());

         MyClassloader2 classloader2 = new MyClassloader2();
         System.out.println(MyClassloader2.class.getClassLoader());
         System.out.println(MyClassloader2.class.getClassLoader().getParent());
         System.out.println(classloader2.getClass().getClassLoader());
         System.out.println(classloader2.getClass().getClassLoader().getParent());

    }


}
