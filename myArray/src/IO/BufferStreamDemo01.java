package IO;

import java.io.*;

/**
 * 字节缓冲流  提高字节读写效率，减少访问底层资源
 *     BufferInputStream 字节缓冲输入流
 *     BufferOutputStream 字节缓冲输出流
 *
 *     字节缓冲流仅仅提供缓冲区，真正的读写数据还是依靠基本的字节流对象
 *
 *     构造方法：
 *         BufferedInputStream(InputStream in)
 *         BufferedOutputStream(OutputStream out)
 *
 *     读写方法同FileStream
 *
 * ===字节缓冲/字符缓冲
 *     BufferedStream字节缓冲流
 *     BufferedReader字符缓冲流
 */
public class BufferStreamDemo01 {
    public static void main(String[] args) throws IOException {
        /**
         * 字节缓冲输出流 BufferOutputStream
         */
//        FileOutputStream fos = new FileOutputStream("myArray\\src\\IO");
//        BufferedOutputStream bos = new BufferedOutputStream(fos);

        //创建字节缓冲流 简写
        //内部默认封装一个8192的byte[]
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("myArray\\src\\IO\\fos.txt"));
        bos.write("Hello\n".getBytes());
        bos.write("world!".getBytes());
        bos.close();

        /**
         * 字节缓冲输入流 BufferInputStream
         */
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("myArray\\src\\IO\\fos.txt"));

        //一次读一个字节
//        int by;
//        while((by = bis.read() )!= -1) {
//            System.out.print((char)by);
//        }

        //一次读一个字节数组
        byte[] bys = new byte[1024];
        int len;
        while((len = bis.read(bys)) != -1) {
            System.out.print(new String(bys,0,len));
        }

        bis.close();



    }
}
