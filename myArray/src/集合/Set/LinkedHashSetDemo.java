package 集合.Set;

import java.util.LinkedHashSet;

/**
 * LinkedHashSet集合特点
 *     哈希表+链表实现的Set接口，具有可预测的迭代次序
 *     由链表保证元素有序，元素的存入和取出顺序是一致的
 *     由哈希表保证元素唯一
 */
public class LinkedHashSetDemo {
    public static void main(String[] args) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("hello");
        linkedHashSet.add("world");
        linkedHashSet.add("java");

        linkedHashSet.add("world");

        for(String s : linkedHashSet){
            System.out.println(s);
        }
    }
}
