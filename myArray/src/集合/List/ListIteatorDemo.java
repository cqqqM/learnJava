package 集合.List;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * ListIterator 列表迭代器
 *     通过List集合的listIterator()方法获取，是List集合特有的迭代器
 *     允许沿任一方向遍历列表，且迭代期间可以修改 并获取迭代器在列表中的位置
 *
 * 常用方法
 *     E next()
 *     boolean hasNext()
 *     E previous
 *     boolean hasPrevious
 *     void add(E e)
 */
public class ListIteatorDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("hello");
        list.add("world");
        list.add("java");

        //正向遍历
        ListIterator<String> lit = list.listIterator();
        while(lit.hasNext()){
            String s = lit.next();
            System.out.println(s);
        }

        //再逆向遍历，一般不用
        while(lit.hasPrevious()){
            String s = lit.previous();
            System.out.println(s);
        }

        //ListIterator的添加方法，Iterator中是没有的
        while(lit.hasNext()) {
            String s = lit.next();
            if (s.equals("world")) {
                list.add(2, "javaee");
            }
        }
    }
}
