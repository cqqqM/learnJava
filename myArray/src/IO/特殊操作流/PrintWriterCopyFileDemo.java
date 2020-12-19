package IO.特殊操作流;

import java.io.*;
import java.nio.Buffer;

/**
 * 打印流实现文件复制
 */
public class PrintWriterCopyFileDemo {
    public static void main(String[] args) throws IOException {
        //打印流只能写不能读，所以需要字符缓冲流读
        BufferedReader br = new BufferedReader(new FileReader("myArray\\src\\IO\\fos.txt"));
        //字符输出流对象
        PrintWriter pw = new PrintWriter(new FileWriter("myArray\\src\\IO\\特殊操作流\\fos.txt"));

        //读写数据 复制文件
        String line;
        while((line=br.readLine())!=null) {
            pw.println(line);
        }
        pw.close();
        br.close();
    }
}
