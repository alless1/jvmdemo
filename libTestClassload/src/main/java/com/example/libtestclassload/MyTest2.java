package com.example.libtestclassload;

/**
 * Created by chengjie on 2020-02-04
 * Description:
 * 常量在编译阶段会存入到调用这个常量的方法所在的类的常量池中，
 * 本质上，调用类并没有直接引用到定义常量的类，因此并不会触发定义常量的类的初始化
 * 注意：这里指的是将常量存放到了MyTest2的常量池中，之后MyTest2与MyParent2就没有任何关系了
 * 运行期没有使用到MyParent2.class字节码文件。
 *
 * 反编译：javap -c com.example.libtestclassload.Mytest2
 * 助记符：
 * ldc表示将String类型的常量值从常量池中推送至栈顶
 * bipush表示将单字节（-128～127）的常量值推送至栈顶(byte、short、int)
 * sipush表示将一个短整型常量值（-32768～32767）推送至栈顶
 * iconst_1表示将int类型数字1推送至栈顶(iconst_m1~iconst_5)(byte、short、int)
 */
public class MyTest2 {
    public static void main(String[] args) {
        System.out.println(MyParent2.str);
        /**
         * 输出结果：
         * MyParent2
         */

        //System.out.println(MyParent2.str2);
        /**
         * 输出结果：
         * MyParent2 static block
         * MyParent2
         */
    }
}
class MyParent2{
    public static final String str = "MyParent2";
    public static String str2 = "MyParent2";
    public static final short num1 = 8;//bipush
    public static final int num2 = 9;//bipush
    public static final short num3 = 4;//iconst_4
    public static final int num4 = 5;//iconst_5
    public static final short num5 = -1;//iconst_m1
    public static final int num6 = -2;//bipush
    public static final int num7 = -1;//iconst_m1
    public static final long num8 = 1;//lconst_1
    public static final long num9 = 10;//ldc2_w
    public static final byte num10 = 7;//bipush
    public static final byte num11 = 3;//iconst_3
    static {
        System.out.println("MyParent2 static block");
    }
}
