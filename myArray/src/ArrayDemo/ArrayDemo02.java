package ArrayDemo;

public class ArrayDemo02 {
    /*
     * 多个数组指向相同内存
     */
    public static void main(String[] args) {

        int[] arr = new int[3];
        arr[0] = 100;
        arr[1] = 200;
        System.out.println(arr);
        System.out.println(arr[0]);

        //定义第二个数组指向第一个数组
        int[] arr2 = arr;
        arr2[0] = 111;
        arr2[1] = 222;
        arr2[2] = 333;
        System.out.println(arr);
        System.out.println(arr[0]);
        System.out.println(arr2);
        System.out.println(arr2[0]);

    }


}
