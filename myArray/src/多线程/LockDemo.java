package 多线程;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * JDK5后提供的锁对象Lock
 *     Lock提供比synchronized语句更广泛的操作
 *     Lock是接口，可以采用实现类ReentrantLock实例化 ReentrantLock()
 *
 *     void lock(); 获得锁
 *     void unlock() 释放锁
 *     一般把加锁代码使用try...finally块封装，保证异常时能正常释放锁
 */
public class LockDemo implements Runnable {
    private int tickets = 100;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (tickets > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets + "张票");
                    tickets--;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        LockDemo st = new LockDemo();
        Thread t1 = new Thread(st,"窗口1");
        Thread t2 = new Thread(st,"窗口2");
        Thread t3 = new Thread(st,"窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}

