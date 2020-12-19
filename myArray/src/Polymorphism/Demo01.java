package Polymorphism;
/*
  多态：同一个对象在不同时刻变现出来的不同形态

  多态前提：
      继承关系 / 方法重写 / 父类引用指向子类对象

===
  多态中成员访问特点：
      成员变量：编译看左边，执行看左边
      成员方法：编译看左边，执行看右边
  为什么？ -因为成员方法有重写，而成员变量没有


===
  多态好处：提高了程序扩展性
       定义方法时，使用父类型作为参数；调用方法时，使用具体的子类型参与操作
   弊端：不能使用子类特有的功能


===
   多态中的转型（类型转换）
       向上转型：从子到父，父类引用指向子类对象
       向下转型：从父到子，父类引用转为子类对象


 */
public class Demo01 {
    public static void main(String[] args) {
        /*************多态中成员的访问特点*************/
        //父类引用指向子类对象
        Animal a = new Cat();

        System.out.println(a.age);  //40，与父类相同，因为成员变量没有重写
//        System.out.println(a.weight); 编译报错

        a.eat(); //猫吃鱼，与子类相同，因为有方法重写
//        a.playGame(); 编译报错
        System.out.println("===================================\n");

        /********多态的好处和弊端**************/
        AnimalOperator ao = new AnimalOperator();
        Cat c = new Cat();
        ao.useAnimal(c);

        Dog d = new Dog();
        ao.useAnimal(d);
        System.out.println("===================================\n");

        /***********多态中的转型**********/
        //向上转型,父类引用指向子类对象
        Animal a1 = new Cat();
        a1.eat();

        //向下转型，父类引用转换到子类对象
        Cat c1 = (Cat)a1;
        c1.eat();
        c1.playGame();
    }
}
