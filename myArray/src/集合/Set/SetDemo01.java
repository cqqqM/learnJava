package 集合.Set;

import java.util.HashSet;
import java.util.Set;

/**
 * Set集合（接口）特点
 *     不包含重复元素
 *     没有索引，不能用for循环遍历
 *
 * 哈希值：JDK中根据对象 地址 或者 字符串 或者 数字 算出来的 int类型 的数值
 *     Object类中有一个方法可以获取对象的哈希值 : public int hashCode()
 *     默认情况下，对象与哈希值一对一，但可以重写hashCode方法修改
 *     中文字符的哈希值容易重复
 *
 * 哈希表
 *     JDK8之前，底层采用数组+链表的方式实现，可以看错元素为链表的数组
 *     JDK8之后，在长度比较长的时候，底层实现了优化
 *
 * HashSet：Set接口的实现类
 *      底层数据结构是哈希表HashMap
 *      对集合的迭代顺序不作保证
 *      默认初始长度16
 *
 *     如何保证不重复？
 *          调用对象的hashCode()方法--根据hash值计算对象存储位置
 *              该位置没有元素，则存储到该位置
 *              该位置有元素，比较该位置的元素与新加入的元素是否相同：hashCode()、equals()，重复则不存
 *
 * LinkedHashSet集合特点
 *      哈希表+链表实现的Set接口，具有可预测的迭代次序
 *      由链表保证元素有序，元素的存入和取出顺序是一致的
 *      由哈希表保证元素唯一
 *
 * TreeSet树集特点：
 *     元素有序：这里的有序不是不是指存储和取出的顺序，而是按照一定规则进行排序。排序方式取决于构造方法：
 *         TreeSet() 根据元素自然排序
 *         TreeSet(Comparator comparator) 根据指定的比较器排序
 *
 *    Comparable自然排序
 *       需要 元素所属的类实现comparable接口，重写compareTo方法
 *       重写方法时要注意主次排序条件
 *
 *    比较器排序
 *       需要 集合构造方法接收Comparator的实现类对象，重写compare（T o1, T o2）方法
 */
public class SetDemo01 {
    public static void main(String[] args) {
        Set<String> stringSet = new HashSet<>();
        stringSet.add("hello");
        stringSet.add("world");
        stringSet.add("java");
        //不包含重复元素
        stringSet.add("world");

        for(String s : stringSet){
            System.out.println(s);
        }

        // 默认情况下，对象与哈希值一对一，但可以重写hashCode方法修改
        System.out.println(stringSet.hashCode());//215735942
        System.out.println("hello".hashCode());//99162322
        System.out.println("world".hashCode());//113318802
        System.out.println("java".hashCode());//3254818

        //中文字符的哈希值容易重复
        System.out.println("重地".hashCode());//1179395
        System.out.println("通话".hashCode());//1179395
        System.out.println("童话".hashCode());//1011096



    }
}
