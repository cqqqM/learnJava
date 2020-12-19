package 网络编程.TCP通信练习;

import java.io.*;
import java.net.Socket;

/**
 * 03.客户端写入数据来自文件，接收服务器端反馈
 *
 * 问题：S/C互相等待，因为读数据的方法是阻塞式的
 *     为了让服务器知道何时停止从流中读取数据，需要定义结束标记
 *     - 自定义的标记有可能在文本中出现导致问题
 *     - socket.shutdownOutput() 发出一个输出结束的标记
 */
public class Client03 {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("mcq",10001);

        //文本文件数据流
        BufferedReader br = new BufferedReader(new FileReader("myArray\\src\\网络编程\\TCP通信练习\\c.txt"));
        //socket数据输出流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        String line;
        while((line=br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

//        //自定义发送结束标记
//        bw.write("886\n");
//        bw.flush();
        s.shutdownOutput();

        BufferedReader brClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
        System.out.println("来自服务器的消息：" + brClient.readLine());

        br.close();
        s.close();
    }
}
