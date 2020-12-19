package 内部类;

/*
  内部类：就是在类中定义一个类

  访问特点：
        内部类可以直接访问外部类的所有成员
        外部类要访问内部类的成员，需要先创建对象

===
成员内部类  可以防止外界访问
    实例化格式：外部类名.内部类名 对象名 = 外部类对象.内部类对象
                Outer.Inner oi = new Outer().new Inner()

===
局部内部类
    是方法中定义的类，外界无法直接使用，需要在方法内创建对象并使用
    该类可以直接访问外部类的成员，也可以访问方法内的局部变量

===
匿名内部类
    本质：一个继承了该类或实现了该接口的子类的 匿名对象
    前提：存在一个类/接口（可以是抽象类
    格式：new 类名/接口名(){重写方法}  new Inner(){ public void show(){} };


 */
public class Demo01 {
    public static void main(String[] args) {
        Outer o = new Outer();
        o.method();
        o.method2();
    }
}
