package 数组;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组:
 *     - 概念: 线性表、连续存储空间、相同类型数据
 *
 *     - 逻辑结构和物理结构
 *         数组元素访问: 寻址公式  a[i] = baseAddress + i * dataTypeSize;  int型size是4个字节
 *         索引为什么从0开始: C语言沿袭; 如果从1开始,寻址时CPU需要多做减法操作
 *
 *     - 数组的特点
 *         高效的随机访问
 *         低效的插入删除: 为了内存的连续性, 插入删除时需要搬运数据
 *             某些特殊情况下, 可以先记录下已删除的数据, 当数组没有空间存储更多数据时才触发一次真正的删除操作.从而大大减少数据搬运
 *             这也是JVM标记清除垃圾的核心思想
 *
 *     - 数组的应用
 *         容器: Java中的ArrayList, C++ STL中的 Vector 细节被封装起来;支持动态扩容
 *         ArrayList初始化,添加元素,扩容 源码分析
 */
public class Demo01 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        list.add("h");
        list.add("i");
        list.add("j");

        /**
         * 超出第一次分配的长度10, 会走到grow方法, 长度变为原来的1.5倍. 扩容到的最大值是 Integer.MAX_VALUE
        *      newCapacity = oldCapacity + (oldCapacity >> 1);
        *  然后开辟新的数组, copy到新数组
        *      elementData = Arrays.copyOf(elementData, newCapacity);
        */
        list.add("k");

        Object o1 = list.get(0);
        System.out.println(o1);


    }
}
