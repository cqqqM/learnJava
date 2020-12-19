package IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节流  2抽象基类
 *     InputStream
 *     OutputStream
 *     子类名特点：子类名都以父类名作为后缀
 *
 * FileOutputStream 文件输出流，用于将数据写入file
 *     构造方法：
 *         FileOutpuStream(String name)
 *         FileOutpuStream(File file)
 *         FileOutpuStream(String name, boolean append)
 *
 *         创建文件输出流，会做三件事
 *             1.调用系统功能创建了文件
 *             2.创建了字节输出流对象
 *             3.让字节输出流对象指向创建的文件
 *
 *     字节流写数据的三种方式
 *         void write(int b) 将指定的字节写入输出流，一次写一个字节数据
 *         void write(byte[] b)  将b.length字节从字节数组里写入输出流，一次写一个字节数组数据
 *         void write(byte[] b, int off, int len)  将len字节 从指定的字节数组 从偏移量off开始 写入输出流，一次写一个字节数组的部分数据
 *
 *         换行:     "\n".getBytes()
 *         追加数据：构造方法中加参数true
 *
 *     void close() 1关闭输出流，2释放资源
 *
 */
public class FileOutputStreamDemo01 {
    public static void main(String[] args) throws IOException {
        //1.创建输出流对象
//        FileOutputStream fos = new FileOutputStream("myArray\\src\\IO\\fos.txt");//源码中包含new File(name)，更方便
//        FileOutputStream fos = new FileOutputStream(new File("myArray\\src\\IO\\fos.txt"));
        //追加写
        FileOutputStream fos = new FileOutputStream("myArray\\src\\IO\\fos.txt",true);

        //2.调用写数据方法
        fos.write(97); //a
        fos.write(98); //b
        fos.write(99); //c.txt
        fos.write(100); //d

//        byte[] bys = {97,98,99,100}; //abcd
        byte[] bys = "abcd".getBytes(); //字符串.getBytes() 返回字符串对应的字节数组
        fos.write(bys);
        fos.write("\n".getBytes());

        fos.write(bys,1,3); //bcd


        //3.关闭输出流
        fos.close();


    }
}
