package 集合;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Collections是针对集合操作的工具类
 *     常用方法：
 *         public static <T extends Comparable <? super T>> void sort(List<T> list) 将指定列表按升序排序
 *         public static void reverse(List<?> list)  反转列表
 *         public static void shuffle(List<?> list)  使用默认随机源 随机排列列表
 */
public class CollectionsDemo {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(20);
        al.add(8);
        al.add(15);
        al.add(231);

        //sort()
        Collections.sort(al);
        System.out.println(al);

        //reverse()
        Collections.reverse(al);
        System.out.println(al);

        //shuffle()
        Collections.shuffle(al);
        System.out.println(al);

    }
}
