package jicheng;

/*
  子类继承父类，可以使用父类中的属性和方法
  子类还可以有自己特有的内容

  访问继承的成员变量/成员方法：  //栈空间原理
        首先在子类方法内部找
        接下来去子类成员内找 this
        最后去父类成员内找 super
        不考虑父类的父类，都找不到时报错

  继承的构造方法：
        子类中所有构造方法默认都会访问父类中无参的构造方法。因为子类需要初始化父类中的数据。
        每个子类第一条语句默认是super()
        ---
        如果父类中没有无参构造方法，1.自己定义无参构造方法 2.使用super带参数 访问父类带参构造方法



 */
public class Zi extends Fu{
    public int height = 175;
    public int age = 20;

    public Zi(){
        super();  //默认调用 父类的无参构造方法
        System.out.println("Zi类无参构造方法调用！");
    }

    public void show() {
        int age = 30;

        System.out.println(age + "," + height); //直接输出的是局部变量
        System.out.println(this.age); //访问本类成员变量
        System.out.println(super.age); //super访问父类成员变量
    }
}
