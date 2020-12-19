package Polymorphism;

public class AnimalOperator {
//    public void useAnimal(Cat c.txt) { //Cat c.txt = new Cat()
//        c.txt.eat();
//    }
//    public void useAnimal(Dog d) { //Dog d = new Dog()
//        d.eat();
//    }

    /******定义时，使用父类型作为参数；使用时，使用具体子类型参与操作*******/
    public void useAnimal(Animal a){
        //Animal a = new Cat()
        //Animal a = new Dog()
        a.eat();
    }
}
