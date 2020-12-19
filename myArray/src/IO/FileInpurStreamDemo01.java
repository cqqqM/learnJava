package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节流读数据  FileInputStream
 *     构造方法:
 *         FileInputStream(String name)
 *
 *     读取方法:
 *         int read() 从输入流读取一个字节的数据
 *         int read(byte[] b)  一次读一个字节数组
 *         int read(byte[] b, int off, int len)  一次读一个字节数组，返回读取到的字节数。EOF时返回-1
 */
public class FileInpurStreamDemo01 {
    public static void main(String[] args) throws IOException {
        /**
         * 一次读一个字节
         */
        FileInputStream fis = new FileInputStream("myArray\\src\\IO\\fos.txt");

        //read()读取一个字节
        System.out.println((char)fis.read()); //字节转字符

        //字节流读数据标准代码
        int by;
        while((by = fis.read()) != -1) { //by != -1
            System.out.print((char)by);
        }

        fis.close();
        System.out.println("\n---");

        /**
         * 一次一个字节数组
         */
        FileInputStream fi2 = new FileInputStream("myArray\\src\\IO\\fos.txt");

//        byte[] by2 = new byte[5]; //一次读5个字节
//        int len = fi2.read(by2); //读入字节数组，返回读入长度
//        System.out.println(len);
//        System.out.println(new String(by2)); //hello
//        //第二次读5个
//        len = fi2.read(by2);
//        System.out.println(len); //读入字节数组
//        System.out.println(new String(by2));// \nworl
//        //第三次读5个
//        len = fi2.read(by2);
//        System.out.println(len); //读入字节数组
//        System.out.println(new String(by2,0,len));// 字符串部分转换

        //标准循环读取字节数组
        byte[] bytes = new byte[1024]; //一般取1024的整数倍
        int len;
        while((len = fi2.read(bytes)) != -1){
            System.out.print(new String(bytes,0,len));
        }
        fi2.close();
    }
}
