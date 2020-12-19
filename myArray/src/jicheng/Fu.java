package jicheng;

public class Fu {
    public int age = 40;

    public Fu(){
        System.out.println("Fu类无参构造方法被调用！");
    }

    public void show(){
        System.out.println("父类show");
    }
    public void method(){
        System.out.println("Fu类method被调用！");
    }
}
