package mcq_exercise;

/*
 * 数组反转
 *      思路：交换变量
 */
public class Demo06 {
    public static void main(String[] args) {
        int[] arr = {19, 28, 35, 46, 98};


        reverse(arr); //数组是一个引用类型，引用类型 形参的改变 直接影响实参
        printArray(arr);
    }

    //数组反转
    public static void reverse(int[] array) {
        //start从前往后，end从后往前
        for (int start = 0, end = array.length - 1; start <= end; start++, end--) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;

        }
    }

    //遍历输出
    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (array.length - 1 == i) { //最后一个元素
                System.out.print(array[i]);
            } else {
                System.out.print(array[i] + ", ");
            }
        }

    }
}
