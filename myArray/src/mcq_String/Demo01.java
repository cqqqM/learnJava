package mcq_String;
import java.util.Scanner;

/*
 * API: Application Programming Interface
 * JAVA API 指的是JDK中提供各种功能的JAVA类
 */
public class Demo01 {
    public static void main(String[] args) {
        //创建sc对象
        Scanner sc = new Scanner(System.in);

        //接收数据
        System.out.println("请输入一个字符串数据: ");
        String line = sc.nextLine();  //ctrl + alt + V 新建变量接收返回值

        //输出结果
        System.out.println("输入的字符串是: " + line);
    }

}
