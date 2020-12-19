package ArrayDemo;

/*
 * 遍历和最大值
 */

public class ArrayDemo05 {
    public static void main(String[] args) {
        int[] arr = {11,22,33,44,55};

        //遍历格式
        for(int x = 0;x<arr.length;x++){
            System.out.println(arr[x]);
        }

        //获取最大值
        int max = arr[0];
        //逐个比对，每次比对将大的那个保存到变量中
        for(int x = 0;x<arr.length;x++){
            if(arr[x] > max){
                max = arr[x];
            }
        }
        System.out.println(max);



    }
}
