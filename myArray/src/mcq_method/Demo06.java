package mcq_method;

/*
 * 方法重载：同一个类中定义的多个方法 同名不同参
 *
 * 重载只针对方法的定义，与方法的调用无关
 *
 * 不能通过返回值来判定两个方法是否相互构成重载
 */
public class Demo06 {
    public static void main(String[] args) {
        System.out.println(compare(10,20));
        System.out.println(compare((byte)10,(byte)10));
        System.out.println(compare((short)20,(short)21));
        System.out.println(compare(15L,15L));
    }
    //int
    public static boolean compare(int a, int b){
        return a == b;
    }

    //byte
    public static boolean compare(byte a, byte b){
        return a == b;
    }

    //short
    public static boolean compare(short a, short b){
        return a == b;
    }

    //long
    public static boolean compare(long a, long b){
        return a == b;
    }
}
