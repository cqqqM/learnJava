package 多线程;

import java.util.*;

/**
 * 线程安全的类：StringBuffer 、 Vector 、 HashTable 需要执行同步
 *
 *     StringBuffer 可变的字符序列  -》 不StringBuilder
 *     Vector 改进了List接口   -》 ArrayList
 *     HashTable  实现了一个哈希表  -》 HashMap
 *
 *     static <T> List<T> synchronizedList(List<T> list) 把集合包装成线程安全的集合类
 */
public class ThreadClassDemo {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();  //内部都是同步方法
        StringBuilder sb2 = new StringBuilder();

        Vector<String> v = new Vector<>(); //内部都是同步方法
        ArrayList<String> arr = new ArrayList<>();

        Hashtable<String, String> hb = new Hashtable(); //内部都是同步方法
        HashMap<String, String> hm = new HashMap<>();

        //static <T> List<T> synchronizedList(List<T> list) 返回支持同步的列表
        ArrayList<String> list = new ArrayList<>();
        Collections.synchronizedList(list);
    }
}
