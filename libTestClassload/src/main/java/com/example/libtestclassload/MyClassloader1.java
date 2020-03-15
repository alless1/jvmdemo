package com.example.libtestclassload;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by chengjie on 2020-02-09
 * Description:
 * 自定义类加载器
 * 但是这个例子里面打印的部分不会执行，因为默认的父类加载器（系统加载器）可以加载成功，不会执行自定义加载的逻辑类。
 */
public class MyClassloader1 extends ClassLoader {
    public MyClassloader1() {
        super();//默认系统类加载器当做该类加载器的父加载器
    }

    public MyClassloader1(ClassLoader parent) {
        super(parent);//指定该类加载器的父加载器
    }

    //重写findClass方法，只有父类加载器无法加载才会执行
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("findClass name:" + name);
        byte[] data = loadClassData(name);
        return defineClass(name, data, 0, data.length);
    }

    //加载类文件
    private byte[] loadClassData(String name) {
        InputStream is = null;
        ByteArrayOutputStream bos = null;
        byte[] data = null;
        try {
            is = new FileInputStream(new File(name + ".class"));
            bos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int off = 0;
            while ((off = is.read(buffer)) != -1) {
                bos.write(buffer, 0, off);
            }
            data = bos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                bos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("datalength:"+data.length);
        System.out.println("data:"+new String(data));
        return data;
    }

    public static void main(String[] args) throws Exception {
        MyClassloader1 myClassloader1 = new MyClassloader1();
        Class<?> aClass = myClassloader1.loadClass("com.example.libtestclassload.MyTest1");
        Object instance = aClass.newInstance();
        System.out.println("aClass:"+aClass);
        System.out.println("instance:"+instance);
    }
}
