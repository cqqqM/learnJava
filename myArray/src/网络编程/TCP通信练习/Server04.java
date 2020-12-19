package 网络编程.TCP通信练习;

import com.sun.security.ntlm.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 04.服务器接收数据，写入到文件，给出反馈。
 *     代码用线程进行封装，为每一个客户端开启一个线程
 */
public class Server04 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10001);

        //为每个客户端开启一个线程，具体操作在线程类中实现
        while(true) {
            Socket s = ss.accept(); //持续监听
            new Thread(new ServerThread(s)).start();
        }

        //服务器一般不关闭socket
//        ss.close();
    }
}
