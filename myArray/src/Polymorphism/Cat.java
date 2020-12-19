package Polymorphism;

public class Cat extends Animal {
    public int age = 20;
    public int weight = 10;

    @Override
    public void eat() {
        //       super.eat(); //调用父类eat方法
        System.out.println("猫吃鱼");
    }

    public void playGame() {
        System.out.println("猫捉迷藏");
    }
}
