package 网络编程;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiverDemo {
    public static void main(String[] args) throws IOException {
        /**
         * UDP接收数据
         */
        //创建socket，接收需指定端口
        DatagramSocket ds1 = new DatagramSocket(10086);

        //创建数据包，用于接收数据的DatagramPacket
        //DatagramPacket(byte buf[], int length)
        byte[] bys1 = new byte[1024];
        DatagramPacket dp1 = new DatagramPacket(bys1,bys1.length);

        //接收数据
        ds1.receive(dp1); //拿到的是整个缓冲区

        //解析并打印
        byte[] data = dp1.getData();
        int len = dp1.getLength();//拿到实际发送的长度
        String dataString = new String(data,0,len);
        System.out.println("数据包内容：" + dataString);

        ds1.close();
    }
}
