package Abstract;

/* abstract抽象类

  抽象方法：没有方法体的方法
  抽象类：包含抽象方法的类

===
  抽象类特点：
      1. 抽象类和抽象方法使用abstract关键字修饰
      2. 抽象类中不一定有抽象方法，有抽象方法的类一定是抽象类
      3. 抽象类不能直接实例化。但可以参照多态的方式，通过子类对象实例化（抽象类多态）
      4. 抽象类的子类：要么重写抽象类中的所有抽象方法，要么本事是抽象类

===
  抽象类成员特点：
      1. 成员方法：可以是变量，也可以是常量
      2. 构造方法：有构造方法，用于子类访问父类数据的初始化
      3. 成员方法：可以是抽象方法，限定子类必须完成某些动作；也可以是非抽象方法，提高代码复用性



 */
public class Demo01 {
    public static void main(String[] args) {
        //按照多态方式创建对象
        Animal a = new Cat("加菲",2);
        a.eat();

    }
}
