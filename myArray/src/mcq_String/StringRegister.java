package mcq_String;

import java.util.Scanner;

public class StringRegister {
    //模拟用户登录
    public static void main(String[] args) {
        String username = "mcq";
        String password = "123";

        for (int i = 0; i < 3; i++) {

            Scanner sc = new Scanner(System.in);
            System.out.println("请输入用户名: ");
            String name = sc.nextLine();

            System.out.println("请输入密码: ");
            String pwd = sc.nextLine();


            if (name.equals(username) && pwd.equals(password)) {
                System.out.println("登陆成功");
                break;
            } else {
                if(i == 3) System.out.println("密码错误次数过多，你的账户已被锁定！");
                else System.out.println("登陆失败，你还有" + (2 - i) + "机会");
            }
        }
    }
}
