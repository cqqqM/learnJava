package IO.特殊操作流;

import java.io.*;
import java.util.Scanner;

/**
 * public static final InputStream in ：标准输入流
 */
public class SystemInDemo {
    public static void main(String[] args) throws IOException {
//        InputStream is = System.in;
//
////        //读取字节流，来自键盘输入
////        int by;
////        while((by=is.read()) != -1) {
////            System.out.print((char)by); //中文会乱码
////        }
//
//        //字节流 转换为 字符流
//        InputStreamReader isr = new InputStreamReader(is);
//
//        //字符流  转换为  字符换缓冲输入流(其中有readLine方法)
//        BufferedReader br = new BufferedReader(isr);

        /****************   字符缓冲输入流，自己实现键盘录入数据  ***********************/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入一个字符串：");
        String line = br.readLine();
        System.out.println("你输入的字符串是: " + line);

        /*****************   Java提供了一个类实现键盘录入   **************/
        Scanner sc = new Scanner(System.in);


    }
}
