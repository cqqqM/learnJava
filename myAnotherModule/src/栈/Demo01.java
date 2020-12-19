package 栈;

import java.util.Stack;

/**
 * 栈
 *     - 概念: 操作受限的线性表，只有一端可以操作。后入先出 LIFO
 *     - 栈的实现：
 *         顺序栈(数组实现)  固定大小/动态扩容
 *         链式栈（链表实现）
 *         操作：入栈(判断)、出栈
 */
public class Demo01 {
    public static void main(String[] args) {
//        ArrayStack s = new ArrayStack(5);
        LinkStack s = new LinkStack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        for (int i = 0; i < 5; i++) {
            System.out.println(s.pop());
        }

        /**
         * Stack类底层实现：基于数组 动态扩容的顺序栈，父类是vector
         *     入栈出栈操作是线程安全的 synchronized
         *     扩容逻辑：，执行Vector扩容方法
         *         public synchronized void addElement(E obj) {
         *             modCount++;
         *             ensureCapacityHelper(elementCount + 1);
         *             elementData[elementCount++] = obj;
         *         }
         *
         *         private void ensureCapacityHelper(int minCapacity) {
         *             // overflow-conscious code
         *             if (minCapacity - elementData.length > 0)  添加元素数量>数组长度时 grow（）
         *                 grow(minCapacity);
         *         }
         *
         *         private void grow(int minCapacity) {  容量不够时，默认长度翻倍，数组搬移
         *             // overflow-conscious code
         *            int oldCapacity = elementData.length;
         *            int newCapacity = oldCapacity + ((capacityIncrement > 0) ?
         *                                            capacityIncrement : oldCapacity);
         *             if (newCapacity - minCapacity < 0)
         *                 newCapacity = minCapacity;
         *             if (newCapacity - MAX_ARRAY_SIZE > 0)
         *                 newCapacity = hugeCapacity(minCapacity);
         *             elementData = Arrays.copyOf(elementData, newCapacity);
         *         }
         */
        Stack stack = new Stack();

        stack.push("hello");
        stack.push("world");
        stack.push(20);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
