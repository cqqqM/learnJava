package IO;

import java.io.*;
import java.util.ArrayList;

/**
 * 集合到文件
 *
 * 文件到集合
 */
public class ArrayListAndFile {
    public static void main(String[] args) throws IOException {
        /****集合到文件****/
        ArrayList<String> arr = new ArrayList<>();
        arr.add("Hello");
        arr.add("World");
        arr.add("JAVA");

        BufferedWriter bw = new BufferedWriter(new FileWriter("myArray\\src\\IO\\fos.txt"));
        for(String s : arr) {
            bw.write(s);
            bw.newLine();
            bw.flush();
        }
        bw.close();

        /*****文件到集合*****/
        ArrayList<String> arr2 = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("myArray\\src\\IO\\fos.txt"));
        String line;
        while((line = br.readLine()) != null) {
            arr2.add(line);
        }
        br.close();        System.out.println(arr2);
    }
}
