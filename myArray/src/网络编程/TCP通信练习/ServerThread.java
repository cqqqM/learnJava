package 网络编程.TCP通信练习;
/**
 * 服务器线程类
 */

import java.io.*;
import java.net.Socket;

public class ServerThread implements Runnable {
    private Socket s;

    public ServerThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        //接收数据写入文本文件
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
//            BufferedWriter bw = new BufferedWriter(new FileWriter("myArray\\src\\网络编程\\TCP通信练习\\s.txt"));
            /**
             * 解决文件名冲突
             */
            int count = 0;
            File file = new File("myArray\\src\\网络编程\\TCP通信练习\\s[" + count + "].txt");
            while(file.exists()) {
                count++;
                file = new File("myArray\\src\\网络编程\\TCP通信练习\\s[" + count + "].txt");
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));

            String line;
            while((line=br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
                bw.flush();
            }

            //给出反馈
            BufferedWriter bwServer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            bwServer.write("文件上传成功");
            bwServer.newLine();
            bwServer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
