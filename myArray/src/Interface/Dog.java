package Interface;

public class Dog extends Animal implements Jumping {
    public Dog() {
    }

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("狗吃肉");
    }

    @Override
    public void jump() {
        System.out.println("狗可以跳高了");
    }
}
