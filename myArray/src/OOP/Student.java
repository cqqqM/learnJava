package OOP;

/*
 * 学生类
 *
 * private方法：保护成员不被别的类使用
 *   如果需要在其他类使用时，一般使用set或get方法
 *   在set方法中可以对输入变量进行控制
 *
 *  this用于修饰成员变量，代表所在类的对象引用
 *  方法的形参如果与成员变量同名，不带this的变量是形参
 */
public class Student {

    private String name; //private方法：保护成员不被别的类使用
    private int age;

    //构造方法
    //public  Student() {}  默认无参构造方法
    public Student(String name) {
        this.name = name;
        System.out.println("调用构造方法");
    }
    public Student(int age) { //重载形式
        this.age = age;
    }
    public Student(String name, int age){ //重载形式
        this.name = name;
        this.age = age;
    }


    //this用于修饰成员变量，代表所在类的对象引用
    //方法的形参如果与成员变量同名，不带this的变量是形参
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        if (age < 0 || age > 120) {
            System.out.println("你给的年龄有误");
        } else {
            this.age = age;
        }
    }

    public int getAge() {
        return age;
    }

    public void show() {
        System.out.println(name + "," + age);
    }

    public void study() {
        System.out.println("好好学习，天天向上");
    }

    public void doHomework() {
        System.out.println("键盘敲烂，月薪过万！");
    }
}
