package 队列;

import org.omg.SendingContext.RunTime;

import java.util.Arrays;

/**
 * 基于数组实现 顺序队列
 *
 */
public class ArrayQueue {
    //定义结构
    //使用Object数组存储元素
    private Object[] elements;
    //队列大小
    private int size;
    //初始容量
    private int DEFAULT_SIZE = 10;
    //容量最大值
    private int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    //头尾指针，因为基于数组，使用int作index即可
    private int head;
    private int tail;

    public ArrayQueue(){
        elements = new Object[DEFAULT_SIZE]; //10
        //初始化首尾指针
        initPointer(0,0);
    }
    public ArrayQueue(int len){
        elements = new Object[len];
        if(len <= 0){
            throw new RuntimeException("队列初始容量错误！");
        }
        initPointer(0,0);
    }

    private void initPointer(int head, int tail){
        this.head = head;
        this.tail = tail;
    }
    //定义操作
    //入队列【支持动态扩容】
    public boolean enqueue(Object element) {
        //校验队列容量是否够用
        ensureCapacityHelper();
        elements[tail++] = element;
        size++;
        return true;
    }

    //出队列
    public Object dequeue() {
        //判断队列中有无数据
        if(head == tail) {
            return null;
        }
        Object obj = elements[head++];
        return obj;
    }

    //获取元素个数
    public int getSize() {
        return size;
    }

    //动态扩容机制
    //1.判断队列容量是否够用
    private void ensureCapacityHelper() {
        //尾指针已经越过队列尾部
        if(tail == elements.length) {
            // 判断队列是否已满，即判断数组中是否还有可用存储空间
            if(size <= elements.length) {
                if(head == 0) {
                    //扩容操作,按原来的数组长度扩容
                    grow(elements.length);
                } else {
                    // 进行数据搬移操作，将数组中的数据依次向前挪动直至顶部
                    for(int i = head; i < tail; i++) {
                        elements[i-head] = elements[i];
                    }
                    //重新初始化头尾指针
                    initPointer(0,0);
                }
            }
        }
    }

    //2.扩容方法
    private void grow(int oldSize) {
        int newSize = oldSize + (oldSize>>1); //扩容1.5倍
        //初始容量为0的情况
        if(newSize - oldSize < 0) {
            newSize = DEFAULT_SIZE;
        }
        //容量过大的情况
        if(newSize - MAX_ARRAY_SIZE > 0) {
            newSize = hugeSize(newSize);
        }
        //数组搬移
        elements = Arrays.copyOf(elements, newSize);
    }

    //3.过大处理
    private int hugeSize(int newSize) {
        return (newSize>MAX_ARRAY_SIZE)? Integer.MAX_VALUE:newSize;
    }


}
