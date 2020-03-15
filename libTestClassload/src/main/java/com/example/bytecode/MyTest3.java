package com.example.bytecode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;

/**
 * Created by chengjie on 2020-02-29
 * Description:
 */
public class MyTest3 {
    /*public void test() {
        try {
            InputStream is = new FileInputStream("xxx.txt");
            ServerSocket serverSocket = new ServerSocket(9999);
            serverSocket.accept();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("finally");
        }
    }*/
    public void test2(int a,long b){
        String str = "sss";
        System.out.println(a+b);
    }
}
