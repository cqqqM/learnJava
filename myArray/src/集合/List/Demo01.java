package 集合.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * List集合特点：
 *     有序
 *     可重复
 *
 * 特有方法
 *     void add(int index, E e) 指定索引插入
 *     E remove(int index)   指定索引删除
 *     E set(int index, E e)  指定索引修改
 *     E get(int index)  获取指定索引元素
 */
public class Demo01 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("hello");
        list.add("world");
        list.add("java");
        list.add("world");

        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String s = it.next();
            System.out.println(s);
        }
    }
}
