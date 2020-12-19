package 网络编程.TCP通信练习;

/**
 * Java的socket是一个全双工套接字，任何的输入流或输出流的close()都会造成Socket关闭。
 *      bw.close() 会导致socket流关闭
 *      socket.shutdownOutputStream() 只关闭输出流，socket不会关闭。关闭的流也不能再开启，缓冲区的消息会被丢弃。
 */

import java.io.*;
import java.net.Socket;

public class Client01 {
    public static void main(String[] args) throws IOException {
        //创建Socket对象
        Socket s = new Socket("mcq",10001);

        //数据来自键盘录入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //封装输出流对象  字节输出流-》字符缓冲输出流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        String line;
        while((line = br.readLine()) != null) {
            if("886".equals(line)) {
                bw.write(line);
                bw.flush();
                s.shutdownOutput();
                break;
            }

            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        //客户端接收数据
        InputStream is = s.getInputStream();
        byte[] bys = new byte[1024];
        int len = is.read(bys);
        System.out.println(new String(bys,0,len));

        s.close();


    }
}
