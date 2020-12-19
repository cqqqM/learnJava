package 网络编程;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSenderDemo {
    public static void main(String[] args) throws IOException {
        /**
         * UDP发送数据
         */
        //创建发送端对象
        DatagramSocket ds = new DatagramSocket();

        //创建并打包
        //用于发送数据的DatagramPacket
        // DatagramPacket(byte buf[], int offset, int length, InetAddress address, int port)
        byte[] bys = "hello,我来了".getBytes();
        int len = bys.length;
        InetAddress inetAddress = InetAddress.getByName("mcq");
        int port = 10086;
        //打包
        DatagramPacket dp = new DatagramPacket(bys,len,inetAddress,port);

        //调用发送数据的方法
        ds.send(dp);

        //关闭发送端
        ds.close();
    }
}
