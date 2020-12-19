package IO;

import java.io.*;

/**
 * 字节流复制视频
 *     字节缓冲流 一次读写一个字节数组  速度最快
 *
 *     字节流/字符流：长度
 *     普通流/缓冲流：减少系统调用
 *     一次读一个/一次读一组
 */
public class AviCopyDemo01 {
    public static void main(String[] args) throws IOException {
        //记录开始时间
        long startTime = System.currentTimeMillis();

        //复制视频
//        method1(); //字节流 单字节80s
//        method2(); //字节流 字节数组151ms
//        method3();  //字节缓冲流 单字节1296ms
        method4();  //字节缓冲流 字节数组69ms


        //记录结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("共耗时" + (endTime-startTime) + "ms");
    }
    //1. 基本字节流  一次读写一个字符
    public static void method1() throws IOException {
        FileInputStream fis = new FileInputStream("D:\\files\\2019-2020\\14学术英语\\blockchain _intro.mp4");
        FileOutputStream fos = new FileOutputStream("D:\\files\\javaWorks\\learnJava\\copy.mp4");
        int by;
        while((by=fis.read()) != -1) {
            fos.write(by);
        }
        fis.close();
        fos.close();
    }

    //2.基本字节流  一次读写一个字节数组
    public static void method2() throws IOException {
        FileInputStream fis = new FileInputStream("D:\\files\\2019-2020\\14学术英语\\blockchain _intro.mp4");
        FileOutputStream fos = new FileOutputStream("D:\\files\\javaWorks\\learnJava\\copy.mp4");
        byte[] bys = new byte[1024];
        int len;
        while((len=fis.read(bys)) != -1) {
            fos.write(bys,0,len);
        }
        fis.close();
        fos.close();
    }

    //3.字节缓冲流  一次读写一个字节
    public static void method3() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\files\\2019-2020\\14学术英语\\blockchain _intro.mp4"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\files\\javaWorks\\learnJava\\copy.mp4"));
        int by;
        while((by=bis.read()) != -1) {
            bos.write(by);
        }
        bis.close();
        bos.close();
    }

    //4.字节缓冲流  一次读写一个字节数组
    public static void method4() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\files\\2019-2020\\14学术英语\\blockchain _intro.mp4"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\files\\javaWorks\\learnJava\\copy.mp4"));
        byte[] bys = new byte[1024];
        int len;
        while((len=bis.read(bys)) != -1) {
            bos.write(bys,0,len);
        }
        bos.close();
        bis.close();
    }
}
