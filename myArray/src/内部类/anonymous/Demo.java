package 内部类.anonymous;

/*
  测试类
  演示匿名测试类在开发中的使用
  匿名对象的本质：一个 继承了该类 或 实现了该接口的子类 的 匿名对象
 */
public class Demo {
    public static void main(String[] args) {
        //创建接口操作类对象，调用method方法
        JumpingOperator jo = new JumpingOperator();
        Jumping j = new Cat();
        jo.method(j);

        System.out.println("如果来了多种动物，每个都只操作一次，还要创建类，实在是太麻烦了\n===========");


        //实际method方法 只需要一个对象
        jo.method(new Jumping() {
            @Override
            public void jump() {
                System.out.println("随便来个动物都可以跳高了");
            }
        });
    }
}
