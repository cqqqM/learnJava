package mcq_String;

import java.util.Scanner;

public class StringTraversal {

    //遍历字符串通用格式

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串: ");
        String line = sc.nextLine();

        //遍历字符串，使用.charAt(i) 方法获取索引i处的字符值
        //System.out.println(line.length());
        for (int i = 0; i < line.length(); i++) {
            System.out.println(line.charAt(i));
        }

    }
}
