package 网络编程.TCP通信练习;

import java.io.*;
import java.net.Socket;

/**
 * 02.客户端写入数据来自文本文件
 */
public class Client02 {
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

        br.close();
        bw.close();

    }
}
