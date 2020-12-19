package Lambda表达式;

/**
 * Lambda表达式
 *     关注具体要做的事情
 *     标准格式：(形式参数) -> {代码块}
 *
 *     ！使用前提
 *         必须有一个接口，接口中有且仅有一个抽象方法
 *         必须有上下文环境，才能推导出lambda对应的接口
 *             根据局部变量的赋值得知lambda对应的接口 Runnable r = () -> System.out.println();
 *             根据调用方法的参数得知lambda对应的接口 new Thread(() -> System.out.println());
 *
 *     lambda表达式和匿名内部类的区别
 *         - 匿名内部类可以是接口、抽象类、具体类；lambda只能是接口
 *         - 接口中有多个抽象方法时，只能使用匿名内部类
 *         - 实现原理上，匿名内部类会生成一个单独的class文件，lambda不会
 *
 */
public class LamdaDemo01 {
    public static void main(String[] args) {

        //匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("多线程程序启动了");
            }
        }).start();

        //lambda表达式
        new Thread( () -> {
            System.out.println("多线程程序启动了");
        }).start();
    }
}
