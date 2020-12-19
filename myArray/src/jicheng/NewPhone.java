package jicheng;

/*
  新手机

  Java中类不支持多继承，支持多层继承

  子类中重写父类方法

  使用override注解，检查重写方法的正确性

  私有方法不能被重写

  子类访问权限不能低于父类 public > 默认 > private

 */
public class NewPhone extends Phone{
    @Override
    public void call(String name) {
        System.out.println("开启视频功能");
        //System.out.println("给" + "打电话");
        super.call(name); //调用父类的功能
        super.send("消息");
    }

    @Override
    void method(){

    }
}
