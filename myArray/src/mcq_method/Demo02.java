package mcq_method;

/*
 * 带参数的方法
 *
 * 形参：方法定义中的参数
 *      等同于定义变量格式
 *
 * 实参：方法调用中的参数
 *      等同于使用变量或常量
 *      要么是一个变量名，要么是一个值
 */


public class Demo02 {
    public static void main(String[] args) {
        getMax(10,20);
    }

    public static void getMax(int a, int b){
        if(a<b){
            System.out.println(b);
        } else {
            System.out.println(a);
        }
    }
}
