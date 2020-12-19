package Lambda表达式.函数式接口;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 函数式接口：有且仅有一个抽象方法的接口
 *     Java中的函数式编程体现就是lambda表达式，所以函数式接口就是可适用于Lambda使用的接口
 *     确保接口中仅有一个抽象方法，java中的lambda才能顺利进行推导
 *
 *     标记：@FunctionalInterface  可写可不写，可以检测一个接口是否是函数式接口
 *
 *     -函数式接口作为局部变量
 *     -函数式接口作为方法的参数
 *     -函数式接口作为方法的返回值 : 如果方法的返回值是一个函数式接口，可以使用lambda表达式作为结果返回
 */
public class Demo01 {
    public static void main(String[] args) {
        //函数式接口作为局部变量
        MyInterface my = () -> System.out.println("函数式接口");
        my.show();

        /**
         * 函数式接口作为方法的参数
         */
        //匿名内部类方式
        startThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "线程启动");
            }
        });

        //lambda表达式方式
        startThread(() -> System.out.println(Thread.currentThread().getName() + "线程启动"));


        /**
         * 函数式接口作为方法的返回值
         * 如果方法的返回值是一个函数式接口，可以使用lambda表达式作为结果返回
         */
        ArrayList<String> arr = new ArrayList<>();
        arr.add("aaaa");
        arr.add("bbb");
        arr.add("cc");
        arr.add("d");
        System.out.println("排序前：" + arr +"\n------------");

        Collections.sort(arr,getComparator());

        System.out.println("排序后：" + arr +"\n------------");

    }

    //函数式接口作为方法的参数
    public static void startThread(Runnable r) {
        new Thread(r).start();
    }

    //函数式接口作为方法的返回值
    private static Comparator<String> getComparator() {
        //匿名内部类方式
//        return new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2) {
//                return s1.length() - s2.length();
//            }
//        };

        //lambda表达式方式
        return (s1,s2) -> s1.length() - s2.length();

    }
}
