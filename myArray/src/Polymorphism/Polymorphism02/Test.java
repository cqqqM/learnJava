package Polymorphism.Polymorphism02;

/*
  多态版 猫和狗案例
 */
public class Test {
    public static void main(String[] args) {
        Animal a = new Cat("加菲",2);
        System.out.println(a.getAge() + "," + a.getAge());
        a.eat();
    }
}
