package 集合.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 源码找错
 * 并发修改异常  ConcurrentModificationException
 *
 * 产生原因：迭代器遍历过程中，通过集合对象修改了集合中元素长度。造成迭代器获取元素时，判断预期修改值和实际修改值不一致
 *
 * 解决方案：用for循环遍历，然后用集合对象做相应操作
 */
public class Demo02 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("hello");
        list.add("world");
        list.add("java");

//        //迭代器方式遍历，并修改，有异常
//        Iterator<String> it = list.iterator();
//        while(it.hasNext()){
//            String s = it.next();
//            if(s.equals("world")){
//                list.add(2,"javaee"); //ConcurrentModificationException
//            }
//        }

        //get方法不做修改判断，所以不会有异常
        for(int i =0;i<list.size();i++){
            String s = list.get(i);
            if(s.equals("world")) {
                list.add("javaee");
            }
        }

        System.out.println(list);

    }
}
