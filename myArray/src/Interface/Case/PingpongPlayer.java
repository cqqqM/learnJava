package Interface.Case;

public class PingpongPlayer extends Player implements SpeakEng {
    public PingpongPlayer() {
    }

    public PingpongPlayer(String name, int age) {
        super(name, age);
    }

    @Override
    void study() {
        System.out.println("乒乓球运动员学习如何发球");
    }

    @Override
    public void eat() {
        System.out.println("乒乓球运动员吃大白菜");
    }

    @Override
    public void speak() {
        System.out.println("乒乓球运动员说英语");
    }
}
