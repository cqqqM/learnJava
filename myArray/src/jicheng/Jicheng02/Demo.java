package jicheng.Jicheng02;

public class Demo {
    public static void main(String[] args) {
        //无参方式构造
        Teacher t1 = new Teacher();
        t1.setName("mcq");
        t1.setAge(30);
        System.out.println(t1.getName() + ", " + t1.getAge());
        t1.teach();

        //带参方式构造
        Teacher t2 = new Teacher("wzj",20);
        System.out.println(t2.getName() + ", " + t2.getAge());
        t2.teach();


    }
}
