package OOP.OOPStandard;

import java.io.Serializable;

public class Student implements Serializable { //可序列化
    //成员变量
    private String name;
    private int age;

    //构造方法
    public Student() {
    }

    public Student(String name, int age) {
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

    //Object类 API 重写toString方法


    @Override
    public boolean equals(Object o) {
        //先比较地址值，如果相同，直接返回true
        if (this == o) return true;

        //如果参数为null，或两个对象不来自同一个类，直接false；
        if (o == null || getClass() != o.getClass()) return false;

        //形参o 向下转型
        Student student = (Student) o; //student = s2

        //比较成员变量是否相同
        if (age != student.age) return false;
        return name != null ? name.equals(student.name) : student.name == null;

    }

    @Override
    public String toString() {
        return "Student{" +
                "name=" + name +
                ",age=" + age +
                "}";
    }
}
