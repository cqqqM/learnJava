package 多线程.生产者消费者;

public class Box {
    private int milk;
    private boolean status = false; //默认奶箱无牛奶

    public synchronized void put(int milk) {
        //如果有牛奶，等待取走
        if(status) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //没有牛奶，生产者放入牛奶，唤醒其他等待的线程,修改状态
        this.milk = milk;
        System.out.println("送奶工将第" + this.milk + "瓶奶放进奶箱");
        notifyAll();
        status = true;
    }

    public synchronized void get() {
        //如果没有牛奶，等待生产
        if(!status) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果有牛奶，消费牛奶，唤醒其他等待的线程，修改状态
        System.out.println("顾客拿走了第" + this.milk + "瓶奶");
        notifyAll();
        status = false;
    }
}
