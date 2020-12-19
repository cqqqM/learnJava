package mcq_StringBuilder;
/*
 * StringBuilder是一个可变的字符串类（内容可变），可以看作一个容器
 *
 * String和StringBuilder区别：内容是否可变
 *
 * 构造方法：
 *      StringBuilder() 构造一个没有字符的字符串构建器，初始容量为16个字符。
 *      StringBuilder(String str) 构造一个初始化为指定字符串内容的字符串构建器。
 *
 * 添加 .append(任意类型)：添加数据，返回对象本身
 * 反转 .reverse()：返回相反的字符序列
 *
 */

public class Demo01 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        sb.append("hello ").append("world");
        System.out.println(sb);

        sb.reverse();
        System.out.println(sb);


    }
}
