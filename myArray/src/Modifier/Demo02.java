package Modifier;

/*
  修饰符
        权限修饰符：private 默认 protected public

        状态修饰符：final最终态 static静态

            final 最终态
                修饰类方法：      不可以被重写；
                修饰成员变量：    不可以被重新赋值；
                修饰类：          不可以被继承
                修饰局部变量：    基本类型的数据值不改变；引用类型的地址值不改变，但地址里内容可变

            static 静态
                修饰成员方法、成员变量
                被类的所有对象共享
                可以通过类名调用 Student.show()
                访问特点：静态的成员方法只能访问静态的成员

 */
public class Demo02 {
    public static void main(String[] args) {

        //final修饰基本类型变量，不可变
        final int age = 20;
//        age = 100; 报错
        System.out.println(age);

        //final修饰引用类型变量：不可以改变指向的地址，但地址中内容可变
        final jicheng.Jicheng03.Cat c1 = new jicheng.Jicheng03.Cat();
//        c1 = new jicheng.Jicheng03.Cat(); 报错
        c1.setAge(2); // 内容可变
    }
}
