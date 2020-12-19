package 常用API;

import java.util.Arrays;
/**    一般的工具类，构造方法用private修饰，成员用 public static 修饰

  Arrays类包含用于操作数组的各种方法

  sort方法      public static void sort(double[] a)

  toString方法  public static String toString(long[] a)

 */
public class ArraysDemo {
    public static void main(String[] args) {
        //定义一个数组
        int[] arr = {24,69,80,57,13};

        System.out.println("排序前:" + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("排序后:" + Arrays.toString(arr));
    }
}
