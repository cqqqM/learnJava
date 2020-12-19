package 网络编程;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * TCP协议  在通信两端各建立一个Socket对象，形成网络虚拟链路
 *     JAVA使用Socket对象来代表两端的通信接口，通过Socket产生IO流来进行网络通信
 *     客户端Socket类，服务端ServerSocket类
 *
 *     TCP发送数据
 *         1.创建客户端Socket对象
 *             Socket(InetAddress address, int port)
 *             Socket(String host, int port)
 *         2.获取输出流，写数据
 *             OutputStream getOutputStream()
 *         3.释放资源
 */
public class TCPSender {
    public static void main(String[] args) throws IOException {
        //创建客户端Socket对象
//        Socket s = new Socket(InetAddress.getByName("mcq"),10000);
        Socket s = new Socket("mcq",10001);

        //获取输出流，写数据
        OutputStream os = s.getOutputStream();
        os.write("hello,tcp, 我来了".getBytes());

        os.close();


    }
}
