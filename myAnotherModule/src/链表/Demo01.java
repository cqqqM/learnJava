package 链表;

import java.util.LinkedList;
import java.util.List;

/**
 * 链表
 *     - 概念: 非连续、节点
 *
 *     - 存储结构: 零散的内存块 ,通过指针串联起来. 节点(存储数据元素, 下一节点地址)
 *
 *     - 类型:
 *         单链表(基本): 元素+next指针;头节点记录基地址, 尾节点next指向空
 *         循环链表: 尾节点next指向头节点
 *         双向链表: 前驱指针prev; 占用空间更多, 灵活性增加; LinkedHashList
 *         双向循环链表
 *
 *     - 与数组比较: 存储结构的不同
 *         插入删除更快, 随机访问低效
 *
 *     - 应用 Linkedlist
 *
 * public class LinkedList<E>
 *     extends AbstractSequentialList<E>
 *     implements List<E>, Deque<E>, Cloneable, java.io.Serializable
 * {
 *     transient int size = 0;
 *     transient Node<E> first;
 *     transient Node<E> last;
 *
 *     public LinkedList() {}
 *
 *     private static class Node<E> {
 *         E item;
 *         Node<E> next;
 *         Node<E> prev;
 *
 *         Node(Node<E> prev, E element, Node<E> next) {
 *             this.item = element;
 *             this.next = next;
 *             this.prev = prev;
 *         }
 *     }
 *
 *     =================================================
 *     添加元素 add(E e)
 *     public boolean add(E e) {
 *         linkLast(e);
 *         return true;
 *     }
 *
 *     void linkLast(E e) {
 *         final Node<E> l = last;
 *         final Node<E> newNode = new Node<>(l, e, null);
 *         last = newNode;
 *         if (l == null)
 *             first = newNode;
 *         else
 *             l.next = newNode;
 *         size++;
 *         modCount++;
 *     }
 *
 *     ===================================================
 *     获取元素 get(int index)
 *
 *
 *
 * ==================================
 * ArrayList与LinkedList比较
 *     1：ArrayList 的实现基于数组，LinkedList的实现基于双向链表
 *     2：对于随机访问，ArrayList 优于 LinkedList，ArrayList 可以根据下标对元素进行随机访问。
 *        而 LinkedList 的每一个元素都依靠地址指针和它后一个元素连接在一起，
 *        在这种情况下，查找某个元素只能从链表头开始查询直到找到为止
 *     3：对于插入和删除操作，LinkedList 优于 ArrayList，
 *        因为当元素被添加到 LinkedList 任意位置的时候，不需要像 ArrayList 那样重新计算大小或者是更新索引。
 *     4. LinkedList 比 ArrayList 更占内存，因为 LinkedList 的节点多存储了两个引用。
 */
public class Demo01 {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);

        head.add(2);
        head.add(3);

        head.show();

        //链表就地逆置
        ListNode newList = reverseList(head);
        newList.show();

    }

    // 定义节点和操作
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        //尾部添加元素
        void add(int x) {
            ListNode curr = this;
            ListNode newNode = new ListNode(x);
            while (curr.next != null) { //找到最后一个节点
                curr = curr.next;
            }
            curr.next = newNode; //尾巴挂上新节点
        }

        //从头到尾打印
        void show() {
            ListNode p = this;
            System.out.print("[");
             while (p != null) {
                System.out.print(p.val + ",");
                p = p.next;
            }
            System.out.println("]");
        }
    }


    /**
     * 单链表就地逆置
     */
    public static ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode p = head;

        while(p != null) {
            ListNode q = p.next;
            p.next = newHead;
            newHead= p;
            p = q;
        }
        return newHead;
    }
}
