package IO;

import java.io.*;

/**
 * 字符缓冲流
 *     BufferedWriter(Writer out)  默认 8192的字符数组
 *     BufferedReader(Reader in)
 *
 *     特有功能：
 *         Writer：
 *             void newline()  写一个行分隔符，自动匹配系统
 *
 *         Reader：
 *             public String readLine()  读取一行。不包括终止符；如果到达结尾，返回null
 *
 */
public class BufferReaderWriter {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("myArray\\src\\IO\\fos.txt"));
        bw.write("Hello");
        bw.newLine();//分隔一行
        bw.flush();  //刷新
        bw.write("World");
        bw.newLine();
        bw.write("BufferedWriter");
        bw.close();

        BufferedReader br = new BufferedReader(new FileReader("fos.txt"));
        String line;
        while((line = br.readLine()) != null) { //终止条件是null，不是-1
            System.out.println(line);
        }
        br.close();

    }
}
