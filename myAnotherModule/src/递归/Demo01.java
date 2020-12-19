package 递归;

/**
 * 理解递归
 *     写递归代码的关键就是找到如何将一个问题拆分成多个小问题的规律，并且基于此写出递推公式，
 *     然后再找到递归终止条件，最后将递推公式和终止条件翻译成代码即可
 *
 *     对于递归代码，这种试图想清楚整个递和归过程的做法，实际上是进入了一个思维误区。
 *     很多时候，我们理解起来比较吃力，主要原因就是自己给自己制造了这种理解障碍。
 *
 *     编写递归代码的关键是，只要遇到递归，我们就把它抽象成一个递推公式，
 *     不用想一层层的调用关系，不要试图用人脑去分解递归的每个步骤
 *
 * 递归中的问题
 *     1.堆栈溢出
 *         递归代码在执行的过程中，每一次递归的调用都会向函数调用栈中压入临时变量，
 *         系统栈或者虚拟机栈的空间一般都不大，如果递归调用的层次很深，一直在压入栈，就会出现堆栈溢出的风险
 *
 *         如何避免？ 1.限制递归深度；2.实时计算剩余栈空间大小
 *
 *     2.重复计算
 *         如斐波那契数列递推公式 (fibonacci(n - 1) + fibonacci(n - 2)) 一个数计算了两次
 *         如何避免？ 可以通过一个数据结构（比如散列表）来保存已经求解过的 f(k)
 *
 * 应用
 *     1.阶乘
 *     2.fibonacci
 *     3.目录拷贝
 */
public class Demo01 {
    public static void main(String[] args) {
        System.out.println(Fib(5));
    }

    private static int Fib(int n) {
        if(n == 1 || n == 2) {
            return 1;
        }
        return Fib(n-1) + Fib(n-2);
    }
}
