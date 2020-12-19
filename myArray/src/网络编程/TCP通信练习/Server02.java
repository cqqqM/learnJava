package 网络编程.TCP通信练习;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 02：服务器接收数据，写文件
 */
public class Server02 {
    public static void main(String[] args) throws IOException {
        //创建+监听
        ServerSocket ss = new ServerSocket(10001);
        Socket s = ss.accept();

        //获取输入流，读数据
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        //写入到文件
        BufferedWriter bw = new BufferedWriter(new FileWriter("myArray\\src\\网络编程\\TCP通信练习\\s.txt"));
        String line;
        while((line=br.readLine()) != null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        bw.close();//关闭文件写入
        ss.close();//关闭socket

    }
}
