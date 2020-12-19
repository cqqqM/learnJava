package mcq_String;

/*
 * 字符串比较：
 *   ==比较：
 *      基本类型：比较数据值是否相同
 *      引用类型：比较地址值是否相同
 *
 *   字符串内容比较：使用.equals()方法
 *
 */
public class stringCompare {
    public static void main(String[] args) {
        //构造方法 获取String对象
        char[] chs = {'a','b','c'};
        String s1 = new String(chs);
        String s2 = new String(chs);

        //直接赋值 获取String对象
        String s3 = "abc";
        String s4 = "abc";

        //比较字符串对象地址值
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s3 == s4);
        System.out.println("==========");

        //比较字符串内容
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s3.equals(s4));
    }

}
