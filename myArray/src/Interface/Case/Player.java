package Interface.Case;

public abstract class Player extends Person {
    public Player() {
    }

    public Player(String name, int age) {
        super(name, age);
    }
    abstract void study();
}
