package com.example.libtestclassload;

/**
 * Created by chengjie on 2020-02-09
 * Description:
 *
 */
public class MyTest9 {
    public static void main(String[] args) {
        MyChild9 myChild9 = new MyChild9();

    }
}

class MyParent9{
   public MyParent9(){
        System.out.println("construction MyParent9");
    }
}

class MyChild9 extends MyParent9{
   public MyChild9(){
        System.out.println("constructino MyChild9");
    }
}
