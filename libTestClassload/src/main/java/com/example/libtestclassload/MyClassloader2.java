package com.example.libtestclassload;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by chengjie on 2020-02-12
 * Description:
 */
public class MyClassloader2 extends ClassLoader {
    private String path = "";

    //默认父加载器为系统加载器
    public MyClassloader2() {
        super();
    }
    //指定父加载器
    public MyClassloader2(ClassLoader classLoader){
        super(classLoader);
        System.out.println("construction:"+classLoader);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("findClass name:" + name);
        byte[] data = loadClassData(name);
        return defineClass(name, data, 0, data.length);
    }

    private byte[] loadClassData(String name) {
        InputStream is = null;
        ByteArrayOutputStream bos = null;
        byte[] data = null;
        try {
            is = new FileInputStream(new File(path+name.replace(".","/") + ".class"));
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
        //System.out.println("datalength:" + data.length);
        //System.out.println("data:" + new String(data));
        return data;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 一：正常运行，是不会执行MyClassloader2类里的findClass方法的。会走系统类加载器，加载成功，不会重复加载。打印结果：
     * clazz1.hashCode:1639705018
     * instance1:com.example.libtestclassload.MyTest1@610455d6
     * clazz2.hashCode:1639705018
     * instance2:com.example.libtestclassload.MyTest1@511d50c0
     *
     * 二：删除项目.class文件下的Mytest1.class文件，会走自定义类加载器，因为类加载器命名空间的问题，会重复加载。打印结果：
     * findClass name:com.example.libtestclassload.MyTest1
     * clazz1.hashCode:1360875712
     * instance1:com.example.libtestclassload.MyTest1@60e53b93
     * findClass name:com.example.libtestclassload.MyTest1
     * clazz2.hashCode:644117698
     * instance2:com.example.libtestclassload.MyTest1@6f94fa3e
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        MyClassloader2 loader1 = new MyClassloader2();
        loader1.setPath("/Users/chengjie/Desktop/");
        Class<?> clazz1 = loader1.loadClass("com.example.libtestclassload.MyTest1");
        Object instance1 = clazz1.newInstance();
        System.out.println("clazz1.hashCode:"+clazz1.hashCode());
        System.out.println("instance1:"+instance1);

        loader1=null;
        clazz1=null;
        instance1=null;
        System.gc();

        //Thread.sleep(1000*1000);

        System.out.println();

        MyClassloader2 loader2 = new MyClassloader2();
        loader2.setPath("/Users/chengjie/Desktop/");
        Class<?> clazz2 = loader2.loadClass("com.example.libtestclassload.MyTest1");
        Object instance2 = clazz2.newInstance();
        System.out.println("clazz2.hashCode:"+clazz2.hashCode());
        System.out.println("instance2:"+instance2);

    }
}
