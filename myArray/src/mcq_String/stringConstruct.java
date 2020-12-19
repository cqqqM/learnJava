package mcq_String;

import javax.lang.model.element.NestingKind;

/*
 * String类在java.lang包下，使用时不需要导包
 * JAVA程序中所有双引号的字符串，都是String类对象
 *
 * 字符串特点：
 *      不可变
 *      可共享
 *      效果上相当于字符数组char[]，底层原理是字节数组byte[]
 */
public class stringConstruct {

    //String类的四种构造方法

    public static void main(String[] args) {
        String s1 = new String();
        System.out.println("s1: " + s1);

        char[] chs = {'a','b','c'};
        String s2 = new String(chs);
        System.out.println("s2: " + s2);

        byte[] bys = {97,98,99};
        String s3 = new String(bys);
        System.out.println("s3: " + s3);

        String s4 = "abc";
        System.out.println("s4: " +s4);
    }
}
