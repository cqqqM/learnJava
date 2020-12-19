package 多线程;

import static java.lang.Thread.sleep;

/**
 * 模拟卖票，三个线程对应三个窗口
 *
 * 多线程问题会有数据安全问题的条件：
 *     多线程环境；共享数据；多条语句操作共享数据
 *
 *     如何解决？ -把多条语句共享数据的代码锁起来，任意时刻只能有一个线程在执行
 *         1.同步代码块
 *             synchronized(锁对象){代码}  锁起需要一起执行的代码块
 *
 *         2.同步方法
 *             修饰符 synchronized 返回值类型 方法名(参数) {}
 *             同步方法的锁对象是this
 *             同步静态方法的锁对象是 类名.class
 */
public class SellTicket implements Runnable{
    private int tickets = 100;
    private Object obj = new Object();

    @Override
    public void run() {
        //同步代码块
//        while (true) {
//            synchronized (obj) {
//                if (tickets >= 0) {
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets + "张票");
//                    tickets--;
//                }
//            }
//        }
        //同步方法
        sellTicket();
    }

    private synchronized void sellTicket(){ //锁对象：this
        while (true) {
            if (tickets >= 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets + "张票");
                tickets--;
            }
        }
    }

/**********************************************************/

    public static void main(String[] args) {
        SellTicket st = new SellTicket();

        Thread t1 = new Thread(st,"窗口1");
        Thread t2 = new Thread(st,"窗口2");
        Thread t3 = new Thread(st,"窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
