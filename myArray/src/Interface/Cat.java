package Interface;

public class Cat extends Animal implements Jumping {
    public Cat() {
    }

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }


    @Override
    public void jump() {
        System.out.println("猫可以跳高了");
    }
}
