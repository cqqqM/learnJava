package 集合.Set;

/** TreeSet集合存储自定义对象，两种初始化（排序）方式
 *
 * Comparable自然排序
 *     无参构造TreeSet集合
 *     需要 元素所属的类实现comparable接口，重写compareTo方法
 *     重写方法时要注意主次排序条件
 *
 * 比较器排序
 *     带参构造TreeSet集合
 *     需要 集合构造方法接收Comparator的实现类对象，重写compare（T o1, T o2）方法
 */

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetStudentDemo implements Comparable<TreeSetStudentDemo> {
    //成员变量
    private String name;
    private int age;

    //构造方法
    public TreeSetStudentDemo() {
    }

    public TreeSetStudentDemo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //成员方法
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void show() {
        System.out.println(this.name + "," + this.age);
    }

    /**
     * 重写compareTo方法
     */
    @Override
    public int compareTo(TreeSetStudentDemo o) {
//        return 0;//判断相同
//        return 1;//判断大于
//        return -1;//判断小于

        //按照年轻从小到大排序
        //年龄相同时，按照姓名排序
        int num = this.age - o.age;
        int num2 = num == 0 ? this.name.compareTo(o.name) : num;
        return num2;
    }


    /***********************************************************************************/


    public static void main(String[] args) {
        //自然排序
        //Student类需要实现comparable接口。重写compareTo方法
        TreeSet<TreeSetStudentDemo> ts = new TreeSet();
        TreeSetStudentDemo s1 = new TreeSetStudentDemo("mcq", 24);
        TreeSetStudentDemo s2 = new TreeSetStudentDemo("zyk", 88);
        TreeSetStudentDemo s3 = new TreeSetStudentDemo("wzj", 2);
        TreeSetStudentDemo s4 = new TreeSetStudentDemo("mtj", 15);

        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);

        for (TreeSetStudentDemo s : ts) {
            s.show();
        }

        /*******************************/
        //比较器排序
        TreeSet<TreeSetStudentDemo> ts1 = new TreeSet<>(new Comparator<TreeSetStudentDemo>() {  // 实现接口匿名内部类
            @Override
            public int compare(TreeSetStudentDemo s1, TreeSetStudentDemo s2) {
                //
                int num = s1.getAge() - s2.getAge();
                int num2 = num == 0 ? s1.getName().compareTo(s2.getName()) : num;
                return num2;
            }
        });
        ts1.add(s1);
        ts1.add(s2);
        ts1.add(s3);
        ts1.add(s4);
        for(TreeSetStudentDemo s : ts1){
            s.show();
        }

    }
}
