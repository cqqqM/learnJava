package mcq_String;

import java.util.Scanner;
//统计字符次数
public class CharCount {
    //统计键盘录入字符串中 大写/小写/数字 个数
    public static void main(String[] args) {
        int c1 = 0, c2 = 0, c3 = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串: ");
        String line = sc.nextLine();

        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if(Character.isDigit(ch)) c3++;
            if(Character.isLowerCase(ch)) c2++;
            if(Character.isUpperCase(ch)) c1++;
        }
        System.out.println("大写个数: " + c1);
        System.out.println("小写个数: " + c2);
        System.out.println("数字个数: " + c3);
    }
}
