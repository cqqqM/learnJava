package Interface;
/**
  接口 用关键字interface修饰: public interface 接口名() {}

  类实现接口用implement表示: public class 类名 implements 接口名() {}

  接口不能实例化，只能实现
        接口的实例化：参照多态的方式，通过实现类对象实例化.👈称为接口多态
        多态的形式：具体类多态、抽象类多态、接口多态
        有父类接口引用指向实现类对象

   接口的实现类，要么重写接口中所有抽象方法，要么是抽象类

   接口与抽象类的关系：抽象类是接口的前提

===
成员特点
    成员变量：只能是常量（默认带有public static final修饰符
    构造方法：接口没有构造方法，因为接口是对行为进行抽象的。（一个类如果没有父类，默认继承Object类
    成员方法：接口中只能有抽象方法（默认带有public abstract修饰符

===
类和接口的关系
    类与类：继承关系。单继承，可多层继承。
    类与接口：实现关系。可多实现。   public class InterImpl extends Object implements Inter1,Inter2,Inter3{}
    接口与接口：继承关系。可多继承。 public interface Inter3 extends Inter1,Inter2{}

===
抽象类和接口的区别
    成员区别：
        抽象类     有变量、常量；有构造方法；有抽象方法和非抽象方法
        接口       只有常量；无构造方法；只有抽象方法

    设计理念区别：
        抽象类：对类抽象，包括属性和行为
         接口 ：对行为抽象
 */
public class Demo01 {
    public static void main(String[] args) {
        /***********接口的实现（接口多态）***************/
        Jumping j = new Cat();
        j.jump();
        System.out.println("=============");

        /***************抽象类的实现（抽象类多态）*****************/
        Animal a = new Cat("加菲",2);
        a.eat();
//        a.jump();
        ((Cat) a).jump();
        System.out.println("=============");

        /***************具体实现类，有最多的方法********************/
        Cat c = new Cat();
        c.eat();
        c.jump();
    }
}
