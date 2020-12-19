package IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节流复制文件
 *     int read(byte[] b)  一次读一个字节数组，返回读取到的字节数
 *     int read(byte[] b, int off, int len)  一次读一个字节数组，返回读取到的字节数。EOF时返回-1
 *
 */
public class FileCopyDemo01 {
    public static void main(String[] args) throws IOException {
        /**
         * 一次读写一个字符
         */
        FileInputStream fi = new FileInputStream("myArray\\src\\IO\\fos.txt");
        FileOutputStream fo = new FileOutputStream("javafile.txt");

        int by;
        while((by = fi.read()) != -1) {
            fo.write(by);
        }

        fi.close();
        fo.close();

        /**
         * 一次读一个字节数组
         */
        FileInputStream fi2 = new FileInputStream("myArray\\src\\IO\\fos.txt");
        FileOutputStream fo2 = new FileOutputStream("fos2.txt");

        byte[] bytes = new byte[1024];
        int len;
        while((len = fi2.read(bytes)) != -1) {
            fo2.write(bytes,0,len);
        }
        fi2.close();
        fo2.close();



    }
}
