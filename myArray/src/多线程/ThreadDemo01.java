package 多线程;

/**
 * 多线程
 *     实现1：继承Thread类
 *         重写run方法，封装被线程执行的代码
 *         run方法直接调用没有启动多线程；start方法启动线程，由JVM调用run方法
 *
 *     实现2：实现Runnable接口
 *         在自定义的类中重写run方法
 *         创建这个类对象，创建Thread类对象，然后把Runnable对象作为Thread构造方法的参数
 *         new Thread(Runnable target)
 *
 *         相比继承Thread类好处：避免了JAVA单继承的局限性；适合多个相同程序处理同一个资源的情况，把线程和程序代码、数据有效分离
 *
 * 常用方法：
 *     String getName() 返回线程的name
 *     void setName(String name)
 *     static Thread currentThread() 返回当前正在执行的线程对象的引用
 *
 * ===========
 * 线程调度模型：  多线程程序的执行具有随机性
 *     分时调度模型：平均分配CPU时间片，轮流使用
 *     抢占式调度模型：优先级高的线程获得更多时间片
 *
 *     java中使用的是抢占式模型，可以设置线程的优先级： 范围1-10，默认5
 *     优先级高仅仅表示线程获取CPU的几率高
 *         public final void setPriority(int newPriority) 更改线程优先级
 *         public final int getPriority()
 *
 * ===========
 * 线程控制：
 *    static void sleep(long millis)  当前线程暂停ms
 *    void join()   等待这个线程死亡
 *    void setDaemon(boolean on)  设置当前线程为守护线程，当运行的线程都是守护线程时，JVM将退出
 *    void stop()
 *
 * ===========
 * 线程的生命周期
 *     新建--就绪--运行--死亡
 *             |阻塞|
 */
public class ThreadDemo01 extends Thread{
    @Override
    public void run() {
        for(int i = 0; i < 100; i++) {
            System.out.println(getName() + ":" + i);
//            try {
//                sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }

    public ThreadDemo01() {}

    public ThreadDemo01(String name) {
        super(name); //使用父类的此构造方法
    }


/******************************************************/
    public static void main(String[] args) throws InterruptedException {
        //查看main方法的线程名称
        System.out.println(Thread.currentThread().getName()); //main


        /**
         * 构造
         */
        //线程无参构造方法
        ThreadDemo01 mythread1 = new ThreadDemo01();
        ThreadDemo01 mythread2 = new ThreadDemo01();
        //带参构造方法 Thread(String name)
        ThreadDemo01 mythread3 = new ThreadDemo01("火箭");

        /**
         * 配置
         */
        //给线程设置名称
        mythread1.setName("高铁");
        mythread2.setName("飞机");
        //查看和修改优先级
        System.out.println(mythread1.getPriority()); //5
        System.out.println(mythread2.getPriority());
        System.out.println(mythread3.getPriority());
        mythread1.setPriority(1);
        mythread2.setPriority(5);
        mythread3.setPriority(10);

        //设置守护线程
        mythread2.setDaemon(true);
        mythread3.setDaemon(true);


        /**
         * 调用和控制
         */
        //直接调用线程的run方法，没有启动多线程
//        mythread1.run();
//        mythread2.run();
        //由JAVA虚拟机调用线程的run方法，启动多线程
        mythread1.start();
        mythread1.join(); //等待线程1的执行
        mythread2.start();
        mythread3.start();




    }
}
