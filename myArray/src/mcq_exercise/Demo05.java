package mcq_exercise;

/*
 * 设计一个方法，比较两个数组元素是否相同
 */
public class Demo05 {
    public static void main(String[] args) {
        int[] arr1 = {11, 22, 33, 44, 5};
        int[] arr2 = {11, 22, 33, 44, 55};

        boolean flag = compare(arr1,arr2);
        System.out.println(flag);

    }

    //比较两个数组是否一致
    public static boolean compare(int[] a, int[] b) {
        //首先比较长度
        if (a.length != b.length) {
            return false;
        }

        //遍历比较数组中的元素
        for(int i =0;i<a.length;i++){
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }
}
