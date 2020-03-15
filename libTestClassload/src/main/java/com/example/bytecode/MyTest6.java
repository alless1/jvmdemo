package com.example.bytecode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import static java.lang.System.in;

/**
 * Created by chengjie on 2020-03-05
 * Description:
 */
public class MyTest6 {
    public void test() {
        int a = 1;
        int b = 2;
        long c = 10;
    }

    public static void main(String[] args) throws Exception {


        InputStream is = new FileInputStream(new File("/Users/chengjie/Desktop/adSource.properties"));
        Properties properties = new Properties();
        properties.load(is);
        is.close();
        Iterator<String> it = properties.stringPropertyNames().iterator();
        while (it.hasNext()) {
            String key = it.next();
            System.out.println(key + ":" + properties.getProperty(key));
        }
        String e = properties.getProperty("abcd");
        String alifaceAd = properties.getProperty("aliFaceAd");
        System.out.println("abcd:"+e);
        System.out.println("aliFaceAd:"+alifaceAd);
        System.out.println(e==alifaceAd);
        System.out.println(alifaceAd.equals(""));
    }

}
