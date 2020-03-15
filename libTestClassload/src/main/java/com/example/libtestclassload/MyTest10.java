package com.example.libtestclassload;

import java.io.File;
import java.util.StringTokenizer;

/**
 * Created by chengjie on 2020-02-22
 * Description:
 * 类加载加载的路径
 */
public class MyTest10 {
    public static void main(String[] args) {
        String bootStr  = "sun.boot.class.path";
        String extStr  = "java.ext.dirs";
        String appStr  = "java.class.path";
        System.out.println(System.getProperty(bootStr));//根加载器加载的类
        System.out.println(System.getProperty(extStr));//拓展类加载器加载的类
        System.out.println(System.getProperty(appStr));//系统类加载器加载的类

        getExtDirs(bootStr);
    }

    private static File[] getExtDirs(String pathStr) {
        String var0 = System.getProperty(pathStr);
        File[] var1;
        if (var0 != null) {
            StringTokenizer var2 = new StringTokenizer(var0, File.pathSeparator);
            int var3 = var2.countTokens();
            var1 = new File[var3];

            for (int var4 = 0; var4 < var3; ++var4) {
                String path = var2.nextToken();
                var1[var4] = new File(path);
                System.out.println(path);
            }
        } else {
            var1 = new File[0];
        }

        return var1;
    }

}
