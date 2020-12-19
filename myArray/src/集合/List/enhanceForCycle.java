package 集合.List;

import java.util.ArrayList;
import java.util.List;

/**
 * 增强for循环：简化数组和Collection集合的遍历
 *     实现Iterable接口的类允许其对象成为增强for语句的目标
 *     JDK5之后出现的，内部原理是一个Iterator迭代器
 *
 *     for(类型 变量名 : 集合类型){
 *
 *     }
 *
 * List遍历的三种方式：Iterator迭代器it.next()、普通for循环+list.get方法、增强for循环
 */
public class enhanceForCycle {
    public static void main(String[] args) {
        //遍历int[]
        int[] arr = {1,2,3,4,5};
        for(int i : arr){
            System.out.println(i);
        }
        System.out.println("==========");

        //遍历String[]
        String[] strArr = {"hello","world","java"};
        for(String  s : strArr){
            System.out.println(s);
        }

        //遍历List
        List<String > list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");

        for(String s : list){
            System.out.println(s);
        }

        //内部原理是一个Iterator迭代器
        for(String s : list){
            if(s.equals("world")){
                list.add("javaee");  //并发修改异常，说明s是一个Iterator元素
            }
        }
    }
}
