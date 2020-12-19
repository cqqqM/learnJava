package IO;

import java.io.*;
import java.util.Arrays;

/**
 * 字符流  由于字节流中操作中文不便，JAVA提供了字符流
 *     字符流 = 字节流 + 编码表（字符流的底层是字节流）
 *
 *     编码：将字符存储到计算机中
 *     解码：将计算机中的二进制数据按某种规则解析出来
 *
 * 字符集：一个系统支持的所有字符的集合
 *     一个字符集必然至少有一套字符编码。ASCII字符集、GBXXX字符集、Unicode字符集等
 *
 *     ASCII字符集：
 *         控制字符、可显示字符
 *         基本ASCII字符集，7位一个字符，共128个字符；
 *         扩展的ASCII字符集，8位一个字符，共256个字符，方便支持欧洲常用字符
 *     GB2312
 *     GBK：双字节编码方案，GB2312的扩展，最常用
 *     GB18030：多字节编码方案，收录最全
 *     Unicode：标准万国码，最多使用4个字节，包含三种编码方案：UTF-8、UTF-16、UTF-32
 *         UTF-8：优先采用的编码
 *
 * ===================================
 * 字符串中的编码解码：
 *     编码 String.getBytes(charsetName)
 *     解码 String(byte[], charsetName)
 *
 * 字符流中的编码解码：
 *     InputStreamReader(InputStream in)  字节流 -> 字符流
 *         读取字节，并用指定编码解析
 *
 *     OutputStreamWriter(OutputStream out)  字符流 -> 字节流
 *         使用指定编码，将写入的字符编码为字节
 *
 *     文件字符流子类，提供默认字符编码和默认缓冲区：
 *         FileReader(String fileName)
 *         FileWriter(String fileName)
 *
 * ===================================
 * 字符流写数据的5种方法
 *     void write(int c.txt) 字符
 *     void write(char[] cbuf)  字符数组
 *     void write(char[] cbuf, int off, int len)
 *     void write(String str)   字符串
 *     void write(String ste, int off, int len)
 *
 *  读数据2种方法
 *     int read();  字符
 *     int read(char[] cbuf) 字符数组
 *
 *  刷新方法 void flush()
 *
 *
 */
public class StreamDemo01 {
    public static void main(String[] args) throws IOException {
        /**
         * 编码 String.getBytes(charsetName)
         */
        String s = "中国";
        byte[] bys = s.getBytes();
        System.out.println(Arrays.toString(bys)); //[-28, -72, -83, -27, -101, -67]
        System.out.println(Arrays.toString(s.getBytes("GBK"))); //[-42, -48, -71, -6]

        /**
         * 解码 String(byte[], charsetName)
         */
        String ss = new String(bys); //
        System.out.println(ss);
        System.out.println("\n===");


        /**
         * 字符流 5种读 2种写 1个flush刷新
         */
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("myArray\\src\\IO\\fos.txt"),"GBK");
//        //1. write(int c.txt)  写一个字符
//        osw.write(97);
//        osw.flush(); //刷新缓冲
//
//        //2. write(char[] cbuf)  写一个字符数组
//        char[] chs = {'a','b','c.txt'};
//        osw.write(chs);
//
//        //3. write(char[] cbuf, int off, int len)
//        osw.write(chs,1,chs.length);
//
//        //4. write(String s)
//        osw.write("中国");

        //5. write(String ste, int off, int len)
        osw.write("中国",0,"中国".length());
        osw.close();

        InputStreamReader isr = new InputStreamReader(new FileInputStream("myArray\\src\\IO\\fos.txt"),"GBK");
//        //1.读取一个字符 read()
//        int ch;
//        while((ch=isr.read()) != -1) {
//            System.out.println((char)ch);
//        }

        //2.读取一个字符数组 read(char[])
        char[] chs2 = new char[1024];
        int len;
        while ((len=isr.read(chs2)) != -1) {
            System.out.print(new String(chs2,0,len));
        }



        isr.close(); //自动刷新缓冲，然后关闭


    }
}
