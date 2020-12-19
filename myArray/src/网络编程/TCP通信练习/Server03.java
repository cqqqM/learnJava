package 网络编程.TCP通信练习;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 03.服务器接收文件，给客户端反馈
 *
 */
public class Server03 {
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
//            if("886".equals(line)) {
//                break;
//            }
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        //给出反馈
        BufferedWriter bwServer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        bwServer.write("文件上传成功");
        bwServer.newLine();
        bwServer.flush();

        bw.close();//关闭文件写入
        ss.close();//关闭socket
    }
}
