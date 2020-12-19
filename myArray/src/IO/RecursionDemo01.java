package IO;

/**
 * 递归：方法定义中调用方法本身的现象
 *
 * 递归解决问题的思路：
 *     把一个复杂问题层层转化为 与原问题相似的 规模较小的问题来求解
 *     递归策略只需要少量代码就可以描述出解题过程需要的多次重复计算
 */
public class RecursionDemo01 {
    public static void main(String[] args) {
        System.out.println(f(20));
        System.out.println(factorial(5));
    }
    /**
     * 递归解决问题，首先要定义一个方法
     *     首先定义一一个出口
     *
     *     栈内存会不断开新的空间，方法、参数不断进栈。直到遇到递归出口，一一出栈。
     *     递归太深会出现StackOverflowError
     */
    //斐波拉契
    public static int f(int n) {
        if(n==1 || n==2){
            return 1;
        } else {
            return f(n - 1) + f(n - 2);
        }
    }

    //阶乘
    public static int factorial(int n) {
        if(n==0 || n==1){
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
