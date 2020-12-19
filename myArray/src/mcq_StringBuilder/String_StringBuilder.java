package mcq_StringBuilder;
/*
 * 为什么需要String和StringBuilder的相互转化？
 *  - 因为SB中提供了append方法和reverse方法
 *
 * SB2Str：
 *      public String toString()
 *
 * Str2SB:
 *      public StringBuilder(String s)
 */

public class String_StringBuilder {
    public static void main(String[] args) {

        /**************** SB2Str *********************/
        StringBuilder sb = new StringBuilder();
        sb.append("Hello world");
        String s = sb.toString();
        System.out.println(s);

        /******************* Str2SB ***********************/
        String s2 = "Hello mcq";
        StringBuilder sb2 = new StringBuilder(s2);
        System.out.println(sb2);
    }
}
