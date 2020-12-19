package ArrayDemo;
/*
 * 数组初始化：为数组中的元素分配内存空间并赋值
 *
 *      动态初始化：只指定长度，由系统分配初始值
 */

public class ArrayDemo {
    public static void main(String[] args) {
        int[] arr = new int[3];  //动态初始化
        int[] arr2 = new int[3];

        //输出数组名
        System.out.println(arr);  // [I@4554617c
        System.out.println(arr2); // [I@74a14482

        //输出数组中的元素
        System.out.println(arr[0]);  // 0

        /*
         * 栈内存：存储局部变量
         *  定义在方法中的变量,例如arr
         *  使用完毕，立即消失
         *
         * 堆内存：存储new出来的内容（实体、对象）
         *  每一个new出来的东西都有一个地址值
         *  使用完毕，会在垃圾回收器空闲时回收
         */

        arr[0] = 100;
        arr[1] = 200;
        arr2[1] = 300;
        System.out.println(arr[0]); //100
        System.out.println(arr2[1]); //300


    }
}
