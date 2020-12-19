package mcq_ArrayList;

/*
 * 定义学生类
 */
public class Demo03Student {
    private String name;
    private int age;

    public Demo03Student(){}
    public Demo03Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }

}
