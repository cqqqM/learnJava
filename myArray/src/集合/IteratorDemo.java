package 集合;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Collection集合的遍历
 * Iterator迭代器，集合的专用遍历方式，依赖于集合而存在
 * Iterator<E> iterator()：返回此集合中元素的迭代器，通过集合的iterator()方法得到
 * <p>
 * 常用方法
 * E next(): 返回下一个元素
 * boolean hasNext（）：若还有迭代元素，返回true
 */
public class IteratorDemo {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.add("hello");
        c.add("world");
        c.add("java");

        //创建集合的迭代器
        Iterator<String> it = c.iterator();
        /*
            public Iterator<E> iterator() {
                return new Itr();
            }

            private class Itr implements Iterator<E> {
                ...
            }
         */

//        System.out.println(it.next());
//        System.out.println(it.next());
//        System.out.println(it.next());
//        System.out.println(it.next());//NoSuchElementException: 表示呗请求的元素不存在

        //迭代器遍历集合
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
        }

    }


}
