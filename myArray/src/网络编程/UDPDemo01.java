package 网络编程;

import java.io.IOException;
import java.net.*;

/**
 * UDP协议
 *     在通信的两端个建立一个Socket对象，但是这两个Socket只是单纯发送、接收消息的对象
 *
 *     Java提供了DatagramSocket类作为基于UDP协议的Socket
 *
 *     发送数据的步骤：
 *         1.创建发送端Socket对象DatagramSocket
 *         2.创建数据DatagramPacket，并打包
 *         3.调用DatagramSocket对象的方法发送数据
 *         4.关闭发送端
 *
 *     接收数据的步骤：
 *         1.创建接收端Socket对象
 *             DatagramSocket(int port)
 *         2.创建一个数据包用于接收数据
 *             DatagramPacket(byte[], int length)
 *         3.调用DatagramSocket对象的方法接收数据
 *             void receive(DatagramPacket p)
 *         4.解析数据包，显示数据
 *             byte[] getData()
 *             int getLength()
 *         5.关闭接收端
 *             void close()
 */
public class UDPDemo01 {
    public static void main(String[] args) throws IOException, InterruptedException {

    }
}
