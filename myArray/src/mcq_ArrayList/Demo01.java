package mcq_ArrayList;
import java.util.ArrayList;

/*
 * 集合类的特点：存储空间可变的存储模型，存储的数据容量可以发生改变 (类似py中的列表
 * 集合类有很多，ArrayList是其中一种
 *
 * ArrayList<E>
 *      可调整大小的数组实现
 *      <E> 集合中元素的数据类型（泛型）
 *      E可以替换成引用数据类型 ArrayList<String>  ArrayList<Student>
 *
 * 构造方法: public ArrayList()
 * 添加方法:
 *      .add(E e)添加到末尾，返回boolean
 *      .add(int index, E e)指定位置插入
 * 删除方法：
 *      .remove(Object o) 删除指定元素，返回boolean
 *      .remove(int index) 删除指定索引的元素，返回被删除的元素
 * 修改方法:
 *      .set(int index, E e) 修改指定索引的元素，返回被修改的元素
 *      .get(int index) 返回指定索引的元素
 * 获取集合中的元素个数：
 *      .size()
 */
public class Demo01 {
    public static void main(String[] args) {
        //创建空的集合对象
        ArrayList<String> array = new ArrayList<>(); //jdk7之后，右边<>可以自动推断类型

        //添加元素
        array.add("hello");
        array.add("world");
        array.add(1,"java");
        //集合索引越界 IndexOutOfBoundsException
        //array.add(5,"java");

        //修改元素
        System.out.println(array.set(0,"你好！"));

        //获取指定索引的元素
        System.out.println(array.get(2));

        //获取元素个数
        System.out.println(array.size());

        //删除元素
        array.remove("world"); //删除指定元素
        array.remove(0); //删除指定位置的元素


        //输出集合
        System.out.println("array: " + array); //array: []

    }
}
