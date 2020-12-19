package 网络编程.TCP通信练习;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server01 {
    public static void main(String[] args) throws IOException {
        //创建+监听
        ServerSocket ss = new ServerSocket(10001);
        Socket s = ss.accept();

        //获取输入流，读数据
        //字节输入流 -》 字符缓冲输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String line;
        while((line=br.readLine()) != null){
            System.out.println(line);
        }

        //给出反馈
//        OutputStream os = s.getOutputStream(); //字节流方式
//        os.write("数据已经收到,再见".getBytes());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        bw.write("数据已收到，再见");  //字符缓冲流方式

        bw.close();//使用bw.close就可以关闭socket

    }
}
