package mcq_String;
import java.util.Scanner;

public class StringReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入一个字符串: ");
        String line = sc.nextLine();

        System.out.println(reverse(line));
    }

    public static String reverse(String s) {
        String snew = "";
        for(int i = s.length()-1; i>=0; i--){  //倒序遍历
            snew += s.charAt(i);
        }

        return snew;
    }
}
