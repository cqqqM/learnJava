package jicheng.Jicheng03;

public class Demo {
    public static void main(String[] args) {
        Cat c1 = new Cat("加菲",3);
        System.out.println(c1.getName() + ", " + c1.getAge());
        c1.catchMouse();
    }
}
