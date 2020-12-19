package 异常;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Throwable类 是Java语言中所有 错误 和 异常 的Throwable类
 *     Error类：严重问题，不需要处理
 *
 *     Exception类: 异常，是可以被程序捕获和处理的
 *         编译时异常 非RuntimeException：编译时就需要处理，否则不通过编译
 *         运行时异常 RuntimeException：编译期不检查，出现问题后需要我们回来修改代码
 *
 * ===
 * Throwable的成员方法
 *     public String getMessage()  返回此throwable的详细消息字符串
 *     public String toString()  返回此可抛出的简短描述
 *     public void printStackTrace()     输出异常的错误信息
 *
 * ===
 * JVM的默认处理方案
 *     1.输出异常的名称、原因、位置
 *     2.程序停止
 *
 * ===
 * try catch异常处理
 *     1.程序从try中代码执行
 *     2.出现异常时，自动生成一个异常对象，被提交给Java runtime系统
 *     3.Java runtime系统接收到异常对象，会到catch中寻找匹配的异常类，找到后进行异常处理
 *     4.执行完毕后，程序继续往下执行
 *
 * ===
 * throws异常处理  【并不是所有异常我们都有权限处理】
 *     用于处理编译时异常：暂不处理异常，仅仅抛出，将来由方法调用者处理
 */
public class Demo01 {
    public static void main(String[] args) {
        System.out.println("开始");
        method();
        System.out.println("结束");
    }

    //try catch处理
    public static void method() {
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[3]);//数组越界异常,这时 new ArrayIndexOutOfBoundsException("xxx");
        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("你访问的数组索引不存在");
            System.out.println(e.getMessage()); //3
            System.out.println(e.toString()); //java.lang.ArrayIndexOutOfBoundsException: 3
            e.printStackTrace(); //标准异常输出
        }
    }

    //编译时异常
    //如果此时处理不了，可以先throws抛出，将来谁调用谁处理
    public static void method2() throws ParseException {
        String s = "2048-08-09";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = sdf.parse(s);
        System.out.println(d);
    }

    //运行时异常
    public static void method3() {
        int[] arr = {1, 2, 3};
        System.out.println(arr[3]);
    }
}
