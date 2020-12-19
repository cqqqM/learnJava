package 集合.Generics;

import OOP.Student;

/**
 * 泛型方法
 *     可以在创建对象时不明确类型，到调用方法时才明确类型
 *     可以接受任意的引用类型
 *
 * 定义格式：修饰符<类型> 返回值类型 方法名(类型 变量名){}
 *     public <T> void show(T t){}
 *
 *
 */
public class GenericMethod {
    public <T> void show(T t){
        System.out.println(t);
    }

    public static void main(String[] args) {
        GenericMethod g = new GenericMethod(); //不明确类型，可以传入任意引用类型
        g.show("hello");
        g.show(25);
        g.show(new Student("mcq",24));
        g.show(0.0005);
    }
}
