package 集合.Generics;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 泛型概述
 *     泛型是JDK5中引入的特性，提供了编译时类型安全检测机制，允许在编译时检测非法的类型
 *     本质是 参数化类型，即所操作的数据类型被指定为一个参数
 *     将类型由原来的具体的类型参数化，在使用/调用时传入具体的类型
 *     泛型类 泛型方法 泛型接口
 *
 * 格式：<类型1，类型2> ， 调用时给到的类型可以看作实参，实参类型必须是引用类型
 *
 * 好处：把运行时的问题提前到编译期间；避免了强制类型转换
 *
 * 泛型类：public class Generic<T>{} , 常见的如T，E，K，V都可以表示泛型
 *
 * 泛型方法：可以在创建对象时不明确类型，到调用方法时才明确类型
 *
 * 泛型接口：使用时需要接口实现类
 *
 *
 * 类型通配符 <?>  对泛型做一些约束
 *      List<?>: 表示元素类型位置的List，它的元素可以匹配任何类型
 *      这种带通配符的List仅表示它是各种泛型list的父类，并不能把元素添加到其中
 *
 *    类型通配符上限 <? extends 类型>
 *        List<? extends Number>, 表示的类型是Number或者其子类型
 *
 *    类型通配符下限 <? super 类型>
 *        List<? super Nmuber>, 表示的类型是Number或者其父类型
 */
public class Generic01<T> {
    //定义泛型类
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
/************************************************************/
    //使用泛型类
    public static void main(String[] args) {
        Generic01<String> g1 = new Generic01<>();
        g1.setT("hello world!");
        System.out.println(g1.getT());

        Generic01<Integer> g2 = new Generic01<>();
        g2.setT(100);
        System.out.println(g2.getT());

        Generic01<Boolean> g3 = new Generic01<>();
        g3.setT(true);
        System.out.println(g3.getT());

    }
}
