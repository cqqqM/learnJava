package 队列;

/**
 * 队列
 *     - 概念：操作受限的线性表，尾部插入，头部取出。先进先出 FIFO
 *         常见循环队列、阻塞队列、并发队列，在很多偏底层系统、框架、中间件中发挥作用。
 *         如高性能队列 Disruptor、Linux环形缓存都用到了循环并发队列
 *         java concurrent 并发包利用 ArrayBlockingQueue 来实现公平锁
 *
 *     - 应用场景
 *         用来存放等待处理元素的集合，这种场景一般用于缓冲、并发访问，及时消息通信，分布式消息队列等
 *
 *
 */
public class Demo01 {
    public static void main(String[] args) {
//        ArrayQueue q = new ArrayQueue(5);
        LinkQueue q = new LinkQueue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        System.out.println(q.getSize());

        //顺序表实现，执行了动态扩容
        q.enqueue(6);
        System.out.println(q.getSize());

        for (int i = 0; i < 6; i++) {
            System.out.println(q.dequeue());
        }
        System.out.println(q.getSize());
    }
}
