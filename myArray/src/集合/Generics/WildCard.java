package 集合.Generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 类型通配符 <?>  对泛型做一些约束
 *     List<?>: 表示元素类型位置的List，它的元素可以匹配任何类型
 *     这种带通配符的List仅表示它是各种泛型list的父类，并不能把元素添加到其中
 *
 * 类型通配符上限 <? extends 类型>
 *     List<? extends Number>, 表示的类型是Number或者其子类型
 *
 * 类型通配符下限 <? super 类型>
 *     List<? super Nmuber>, 表示的类型是Number或者其父类型
 */
public class WildCard {
    public static void main(String[] args) {
        List<?> list1 = new ArrayList<Object>();
        List<?> list2 = new ArrayList<Number>();
        List<?> list3 = new ArrayList<Integer>();

        //extends 只能匹配Number及其子类，Object类编译报错
//        List<? extends Number> list4 = new ArrayList<Object>();
        List<? extends Number> list5 = new ArrayList<Number>();
        List<? extends Number> list6 = new ArrayList<Integer>();

        //super 只能匹配Number及其父类，Integer类编译报错
        List<? super Number> list7 = new ArrayList<Object>();
        List<? super Number> list8 = new ArrayList<Number>();
//        List<? super Number> list9 = new ArrayList<Integer>();
    }
}
