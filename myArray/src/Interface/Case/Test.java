package Interface.Case;
/*
    分析类设计：从具体到抽象
    类设计实现：从抽象到具体
    使用：使用的是具体的类对象
 */
public class Test {
    public static void main(String[] args) {
        PingpongPlayer pp = new PingpongPlayer("王浩",30);
        pp.eat();
        pp.speak();
        pp.study();

        BasketballPlayer bp = new BasketballPlayer("姚明",35);
        bp.eat();
        bp.study();
    }
}
