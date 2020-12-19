package 集合;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Collection集合
 *     是单例集合的顶层接口，表示一组元素
 *     JDK不提供此接口的直接实现，只提供更具体的子接口实现（如Set、List
 *     集合中只能存储引用类型
 *
 *     创建Collection集合的对象
 *         1.使用多态的方式
 *         2.使用具体实现类如ArrayList
 *
 *     ===
 *     常用方法
 *         boolean add(E e)            添加元素
 *         boolean remove(Object o)    删除指定元素的单个实例（如果存在
 *         void clear()                清空集合中的元素
 *         boolean contains(Object o)  判断集合是否包含指定元素
 *         boolean isEmpty()           判断集合是否为空
 *         int size()                  返回集合长度
 *
 *        Alt + 7 查看类结构
 *
 *  Collections 集合工具类
 *        public static <T extends Comparable <? super T>> void sort(List<T> list) 将指定列表按升序排序
 *        public static void reverse(List<?> list)  反转列表
 *        public static void shuffle(List<?> list)  使用默认随机源 随机排列列表
 */
public class Demo01 {
    public static void main(String[] args) {
        //创建对象
        Collection<String> c = new ArrayList<>();

        //add
        c.add("hello");
        c.add("world");
        c.add("world");
        c.add("java");
        System.out.println(c);//[hello, world, java] 指定格式，所以Collection类重写了toString方法

        //remove
        c.remove("world");
        System.out.println(c);

        //contains
        System.out.println(c.contains("jave"));

        //size
        System.out.println(c.size());

        //clear
        c.clear();

        //isEmpty
        System.out.println(c.isEmpty());
    }
}
