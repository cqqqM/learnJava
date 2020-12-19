package 常用API;
/*
  Math类的常用方法

  没有构造方法的类，成员都是静态的，可以用类名.来访问
 */
public class MathDemo {
    public static void main(String[] args) {
        //Math.abs()
        System.out.println(Math.abs(-88)); //88

        //Math.ceil()
        System.out.println(Math.ceil(12.34)); //13.0

        //Math.floor()
        System.out.println(Math.floor(12.56)); //12.0

        //Math.round() 四舍五入返回int
        System.out.println(Math.round(12.34f)); // 12

        //Math.max()
        System.out.println(Math.max(12,13)); //13

        //Math.pow()
        System.out.println(Math.pow(2.0,3.0)); //8.0

        //Math.random() 返回 [0.0, 1.0)
        System.out.println(Math.random()); //0.07869984974262612
    }
}
