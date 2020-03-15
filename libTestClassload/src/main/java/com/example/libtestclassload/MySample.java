package com.example.libtestclassload;

/**
 * Created by chengjie on 2020-02-22
 * Description:
 */
public class MySample {
    public MySample(){
        new MyCat();
    }

    public static void main(String[] args) throws Exception {
        MyClassloader2 loader = new MyClassloader2();
        loader.setPath("/Users/chengjie/Desktop/");
        Class<?> aClass = loader.loadClass("com.example.libtestclassload.MySample");
        Object instance = aClass.newInstance();
    }
}
