package 集合.Set;

import javax.swing.event.TreeSelectionEvent;
import java.util.TreeSet;

/**
 * TreeSet树集特点：
 *    元素有序：这里的有序不是不是指存储和取出的顺序，而是按照一定规则进行排序。排序方式取决于构造方法：
 *        TreeSet() 根据元素自然排序
 *        TreeSet(Comparator comparator) 根据指定的比较器排序
 *
 * Comparable自然排序
 *      需要 元素所属的类实现comparable接口，重写compareTo方法
 *      重写方法时要注意主次排序条件
 *
 * 比较器排序
 *      需要 集合构造方法接收Comparator的实现类对象，重写compare（T o1, T o2）方法
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>();  //集合只能存储引用类型，所以存储基本类型时需要使用其包装类类型
        ts.add(5);
        ts.add(10);
        ts.add(20);
        ts.add(3);
        ts.add(50);

        System.out.println(ts);//[3，5，10，20，50]
    }
}
