package 网络编程;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP接收数据
 *     1.创建服务器端Socket对象
 *         ServerSocket(int port)  创建绑定到此端口的服务器套接字
 *     2.监听客户端的连接，返回一个Socket对象
 *         Socket accept()
 *     3.获取输入流，读数据
 *         InputSream getInputStream()
 *     4.释放资源
 */
public class TCPReceiver {
    public static void main(String[] args) throws IOException {
        //创建服务器Socket
        ServerSocket ss = new ServerSocket(10001);

        //监听客户端的连接
        Socket s = ss.accept();

        //获取输入流，读数据
        InputStream is = s.getInputStream();
        byte[] bys = new byte[1024];
        int len = is.read(bys);
        System.out.println(new String(bys));

        s.close();
        ss.close();
    }
}
