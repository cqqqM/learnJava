package 网络编程;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 在网络通信协议下，实现网络互联的不同计算机上运行的程序间可以进行数据交换
 *     三要素：IP-、port、网络通信协议
 *
 * IP：网络中设备的唯一标识
 *     IPV4/IPV6
 *     JAVA提供InetAddress类，方便对IP地址获取和操作：
 *         static InetAddress getByName(String host)  确定主机名称的IP地址
 *         String getHostName()  获取此IP地址的主机名
 *         String getHostAddress()  返回文本中显示的IP地址字符串
 *
 * 端口：设备上应用程序的唯一标识
 *     两个字节表示的整数 0~65535  其中0~1023用于知名网络服务和应用，普通应用程序使用1024以上的端口号
 *
 * 协议：计算机通信中，连接和通信的规则
 *     UDP/TCP
 */
public class NetworkDemo01 {
    public static void main(String[] args) throws UnknownHostException {
//        InetAddress address = InetAddress.getByName("mcq");
        InetAddress address = InetAddress.getByName("192.168.64.1");

        //主机名
        String hostName = address.getHostName();
        //IP地址
        String hostAddress = address.getHostAddress();
        System.out.println(hostName + "，" + hostAddress);

    }
}
