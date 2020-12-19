package IO.特殊操作流;

import java.io.PrintStream;

/**
 * 标准输出流
 *     public static final PrintStream out
 *     能方便地打印各种数据值
 *
 *     System.out的本质 是一个字节输出流
 *
 *     输出语句的本质 是一个标准输出流
 *
 */
public class SystemOutDemo {
    public static void main(String[] args) {
        PrintStream ps = System.out;
        ps.println(100);
        ps.print("hello"); //sout("hello")


    }
}
