package 栈;

/**
 * 固定长度的顺序栈
 */
public class ArrayStack {
    //栈大小
    private int size;
    //默认容量10
    private int DEFAULT_CAPACITY = 10;
    //栈数据
    private Object[] elements;
    private int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    //默认构造
    public ArrayStack() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    //指定大小构造
    public ArrayStack(int len) {
        elements = new Object[len];
    }

    //入栈：容量够时入栈，否则抛出异常
    public boolean push(Object element) {
        try {
            checkCapacity(size + 1);
            elements[size++] = element;
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    //检查栈容量
    private void checkCapacity(int minCapacity) {
        if (elements.length - minCapacity < 0) {
            throw new RuntimeException("栈容量不够！");
        }
    }

    //出栈
    public Object pop() {
        if (size < 0) {
            return null;
        }
        Object o = elements[size - 1]; //长度-1：最后一个元素位置
        elements[--size] = null;
        return o;
    }

    //获取大小
    public int size() {
        return size;
    }
}
