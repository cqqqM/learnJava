package mcq_method;

/*
 * 方法的参数传递
 *
 * 对于基本数据类型的参数，形式参数的改变，不影响实际参数的值
 *
 * 对于引用类型的参数，形式参数的改变，影响实际参数的值
 */
public class Demo07 {
    public static void main(String[] args) {
        int number = 100;
        System.out.println("调用前：" + number);
        change(number);
        System.out.println("调用后: " + number); //形参改变 不影响实参的值

        int[] arr = {10,20,30};
        System.out.println("调用前：" + arr[1]);
        change(arr); //传入引用类型
        System.out.println("调用前：" + arr[1]);//形参改变 影响实参的值
    }

    //int 基本数据类型
    public static void change(int number) {
        number = 200;
    }

    //int[] 引用数据类型
    public static void change(int[] arr){
        arr[1] = 200;
    }
}
