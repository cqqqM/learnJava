package mcq_ArrayList;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * 存储学生对象并遍历
 */
public class Demo03StudentTest {
    public static void main(String[] args) {
        //创建集合对象
        ArrayList<Demo03Student> array = new ArrayList<>();

        //创建学生对象
        Demo03Student s1 = new Demo03Student("mcq", 23);
        Demo03Student s2 = new Demo03Student("zyk", 80);
        Demo03Student s3 = new Demo03Student("mtj", 18);

        //添加学生到集合中
        array.add(s1);
        array.add(s2);
        array.add(s3);

        //遍历集合
        for (int i = 0; i < array.size(); i++) {
            Demo03Student s = array.get(i); //ctrl + alt + v 自动生成左边
            System.out.println(s.getName() + "," + s.getAge());
        }

        //遍历集合 迭代器方式
        Iterator<Demo03Student> it = array.iterator();
        while(it.hasNext()){
            Demo03Student s = it.next();
            System.out.println(s.getName() + "," + s.getAge());
        }
    }
}
