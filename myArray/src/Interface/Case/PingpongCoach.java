package Interface.Case;

public class PingpongCoach extends Coach implements SpeakEng{
    public PingpongCoach() {
    }

    public PingpongCoach(String name, int age) {
        super(name, age);
    }

    @Override
    void teach() {
        System.out.println("乒乓球教练教乒乓球");
    }

    @Override
    public void eat() {
        System.out.println("乒乓球教练吃小白菜");
    }

    @Override
    public void speak() {
        System.out.println("乒乓球教练要说英语");
    }
}
