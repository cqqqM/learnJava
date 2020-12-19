package Interface;

import 内部类.anonymous.Demo;

/**
 * 接口的组成
 *     - 常量 public static final
 *     - 抽象方法 public abstract
 *         必须重写
 *
 *     - 默认方法(jdk8)
 *         非抽象，不强制重写。主要用于接口的升级而不破坏现有的代码
 *         格式：public default 返回类型 方法名(参数){}   public可以省略
 *
 *     - 静态方法(jdk8)
 *         只能通过接口名调用，不能通过实现类名或对象名调用
 *         格式：public static 返回类型 方法名(参数){}   public可以省略
 *
 *     - 私有方法(jdk9)
 *         供默认方法或静态方法调用，提升代码复用性
 *         可以是静态方法，也可以非静态方法
 *         格式1：private 返回类型 方法名（参数）{}
 *         格式2：private static 返回类型 方法名（参数）{}
 */
public class Demo02 implements Demo002{
    public static void main(String[] args) {
        Demo002 inter = new Demo02();

        //默认方法通过实现类对象调用
        inter.show1();
        System.out.println("---");
        inter.show2();
        System.out.println("---");

        //静态方法通过接口类名调用
        Demo002.method1();
        System.out.println("---");
        Demo002.method2();

    }
}
