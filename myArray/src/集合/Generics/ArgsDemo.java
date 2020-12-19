package 集合.Generics;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * 可变参数
 *     参数个数可变，用作方法的形参出现，那么方法参数的个数就是可变的了
 *     格式：public static int sun(int... a) {}
 *     注意：
 *         参数实际是一个数组
 *         包含多个参数时，可变参数需要放到最后
 *
 * 可变参数的使用：
 *    Arrays工具类中有一个静态方法
 *        public static <T> List<T> asList(T... a): 返回由指定数组支持的固定大小的列表
 *        Arrays.asList() 可以改，不能增删
 *
 *    List接口中有一个静态方法：
 *        public static <E> List<E> of(E... elements): 返回包含任意数量元素的不可变列表
 *        List.of() JDK9中出现，不能增删改
 *
 *    Set接口中有一个静态方法：
 *        public static <E> Set<E> of(E... elements): 返回包含任意数量元素的不可变集合
 *        Set.of() JDK9中出现，给定元素不能重复，不能增删改
 *
 */
public class ArgsDemo {
    public static void main(String[] args) {
        System.out.println(sum(14,20));
        System.out.println(sum(10,20,30));

        //Arrays.asList() 可以改，不能增删
        List<String> list = Arrays.asList("hello","world","javaee"); //长度固定为3
//        list.add("javaee");//UnsupportedOperationException
//        list.remove("hello");//UnsupportedOperationException
        list.set(0,"bye");
        System.out.println(list);

        //List.of() JDK9中出现，不能增删改
//        List<String> list2 = List.of("hello","world")；

        //Set.of() JDK9中出现，给定元素不能重复，不能增删改
//        Set<String> set = Set.of("hello","world","java");


    }

    public static int sum(int... a){
        System.out.println(a); //[I@4554617c  [I 说明args被封装进了int类型的数组
        int sum = 0;
        for(int i : a){
            sum += i;
        }
        return sum;
    }

    public static int sum1(int b, int... a){ //可变参数要放在最后
        return 0;
    }
}
