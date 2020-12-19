package IO.特殊操作流;

import java.io.*;

/**
 * 打印流：
 *     字节打印流 PrintStream
 *         构造方法
 *             PrintStream(String Filename) 使用指定文件名创建新的打印流
 *             PrintStream(File file)
 *         特点：
 *              只负责输出数据，不负责读取
 *              使用父类方法写数据write，查看的时候会转码；使用特有方法写数据，查看的数据原样输出print
 *
 *
 *     字符打印流 PrintWriter
 *         构造方法：
 *             PrintWriter(String fileName)
 *             PrintWriter(Writer out, boolean autoFlush) 自动刷新输出缓冲区
 *
 *
 */
public class PrintStreamDemo {
    public static void main(String[] args) throws IOException {
        PrintStream ps = new PrintStream("myArray\\ps.txt");

        //字节输出流有的方法
        ps.write(97);

        //特有方法 写数据
        ps.print(97);
        ps.println(98);

        ps.close();

        /*******************   PrintWriter构造1   **********************/
        PrintWriter pw = new PrintWriter("myArray\\ps.txt");
        //父类的write方法
        pw.write("hello");
        pw.flush();
        pw.println();

        //特有方法
        pw.println("hello");
        pw.println("world");
        pw.flush();

        /************   PrintWriter 构造2  自动刷新 *****************/
        PrintWriter pw2 = new PrintWriter(new FileWriter("myArray\\ps.txt"),true);
        pw2.println("hello,world!");

    }
}
