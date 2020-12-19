package 常用API;

/**
 * 基本类型包装类
 * 将基本类型封装成对象好处在于，可以在对象中定义更多的功能方法操作该数据
 * 常用操作：基本数据类型 与 字符串 相互转换
 * <p>
 * 获取一个Integer类型：Integer.valueof()
 */
public class IntegerDemo {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE); //-2147483648
        System.out.println(Integer.MAX_VALUE); //2147483647

        Integer i1 = Integer.valueOf(100);
        System.out.println(i1);

        Integer i2 = Integer.valueOf("120");
        System.out.println(i2);


        /**
         * 与String相互转换：
         *           int转为String:  public static String valueof(int i)  String类方法
         *           String转为int:  public static int parseInt(String s)  Integer类方法
         *
         *           int 2  String
         */
        int num = 100;
        String s1 = "" + num; //拼接方式转换
        String s2 = String.valueOf(num);

        /**         String  2  int  */
        String s = "100";
        //方式1   String -- Integer -- int
        Integer ii1 = Integer.valueOf(s); //String2Integer
        int ii2 = i1.intValue(); //Integer2int

        //方式2  String -- int
        int ii3 = Integer.parseInt(s);


        /**  自动装箱和拆箱
         *      装箱：基本数据类型 -》 对应的包装类类ing
         *      拆箱：包装类类型   -》 对应的基本数据类型
         *
         *   !使用包装类类型，操作前最好先判断是否为null
         *   只要是对象，在使用前必须进行不为null的判断
         */
        Integer i = Integer.valueOf(100);//装箱
        Integer ii = 100; //自动装箱

        ii = ii.intValue() + 200;//拆箱
        ii = ii + 200; //自动拆箱

        Integer iii = null;
//        iii += 300; //NullPointerException



    }
}
