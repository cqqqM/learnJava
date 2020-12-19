package 集合.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * List集合常用子类：
 *    ArrayList 底层实现是数组，查询块，增删慢
 *    LinkedList 底层实现是链表，查询慢，增删快
 */
public class ArrayListAndLinkedList {
    public static void main(String[] args) {
        /** 分别使用ArrayList和LinkedList 存储字符串 并遍历 */

        ArrayList<String> array = new ArrayList<>();
        array.add("hello");
        array.add("world");
        array.add("java");
        //三种遍历方式
        Iterator<String> it = array.iterator();
        while(it.hasNext()){
            String s = it.next();
            System.out.println(s);
        }
        for(int i = 0; i<array.size();i++){
            System.out.println(array.get(i));
        }
        for(String  s : array){
            System.out.println(s);
        }

        System.out.println("===============");

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("hello");
        linkedList.add("world");
        linkedList.add("java");
        for(String s : linkedList){
            System.out.println(s);
        }


    }
}
