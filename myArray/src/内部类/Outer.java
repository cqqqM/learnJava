package 内部类;

public class Outer {
    private int num = 10;

    //创建成员内部类
    private class InnerClass{
        public void show(){
            System.out.println(num); //访问外部类的值
        }
    }

    //间接访问成员内部类的方法
    public void method() {
        InnerClass i = new InnerClass();
        i.show();
    }

    public void method2() {
        int num2 = 20;
        //在方法中 创建局部内部类
        class Inner{
            public void show(){
                System.out.println(num2);
            }
        }
        Inner i = new Inner();
        i.show();
    }
}
