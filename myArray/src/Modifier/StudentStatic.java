package Modifier;
/*
  体现static访问特点

        静态的成员方法只能访问静态的成员
 */
public class StudentStatic {
    private String name = "林青霞";
    private static String school = "北京交大";

    //非静态成员方法1
    public void show1() {}

    //非静态成员方法2
    public void show2() {
        System.out.println(name);
        System.out.println(school);
        show1();
        show3();
    }

    //静态成员方法3
    public static void show3(){

    }

    //静态成员方法4
    public static void show4(){
//        System.out.println(name); 访问了非静态变量
        System.out.println(school);
//        show1();  访问了非静态方法
        show3();
    }
}
