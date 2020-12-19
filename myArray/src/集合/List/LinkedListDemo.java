package 集合.List;

import java.util.LinkedList;

/**
 * LinkedList集合特有功能，针对 头尾节点的 查询、插入、删除
 *      public void addFirst()
 *      public void addLast()
 *      public E getFirst()
 *      public E getLast()
 *      public E removeFirst()
 *      public E removeLast()
 *
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Hello");
        linkedList.add("world");
        linkedList.add("java");

        //add
        linkedList.addFirst("addFirst!");
        linkedList.addLast("addLast!");
        System.out.println(linkedList);

        //remove
        String s = linkedList.removeFirst();
        String s1 = linkedList.removeLast();

        //get
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());

    }
}
