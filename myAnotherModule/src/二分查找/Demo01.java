package 二分查找;

/**
 * 二分查找
 *     在一个有序的数据集合寻找特定元素
 *     - 原理：每次都通过跟区间的中间元素对比，将待查找的区间缩小为之前的一半，直到找到要查找的元素。或者区间被缩小为0
 *     - 时间复杂度 O(logN)
 *     - 适用条件
 *         待查找的数据使用数据存储；有序；数据量适中
 *
 */
public class Demo01 {
    public static void main(String[] args) {
        int[] arr = {-1,0,8,8,12,17,20,25,29,29,29,31,56,95};
        int index = binarySearch(arr,29);
        System.out.println(index);
    }

    private static int binarySearch(int arr[], int num) {
        int low = 0;
        int high = arr.length;
        while(low < high){
            int mid = (low+high)/2;
            if(num == arr[mid]) return mid;
            if(num > arr[mid]) {
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return -1;
    }
}
