package 排序;

import java.util.Arrays;

/**
 * 排序
 *
 *     评价：
 *         时间复杂度：最好、最坏、平均
 *         空间复杂度：in-place原地排序、out-place占用额外内存
 *         稳定性：如果待排序的序列中存在值相等的元素，经过排序之后，相等元素之间原有的先后顺序不变。
 */
public class Demo01 {
    public static void main(String[] args) {
        int[] arr = {5,2,6,9,0,3};

//        BubbleSort(arr);
//        BubbleSort2(arr);
//        InsertSort(arr);
//        SelectSort(arr);
//        arr = MergeSort(arr); //不是就地的排序，需要赋值！
        QuickSort(arr,0,arr.length-1);

        for(int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }


    /**
     * 冒泡排序
     *     1.比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     *     2.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数
     *     3.针对所有的元素重复以上的步骤，除了最后一个；
     *     每一次循环会把最大的元素冒泡到顶端
     * 改进
     *     当某次冒泡时发现已经没有数据需要进行交换时，说明所有元素都已经达到有序状态了
     * 评价
     *     最好有序 时间O(N); 最坏倒序 时间O(N²); 空间O(1); 稳定排序
     */
    private static void BubbleSort(int[] arr) {
        //判断长度
        if(arr.length <= 1) return;
        for(int i = 0; i < arr.length-1; i++) {
            for(int j = 0; j < arr.length-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    private static void BubbleSort2(int[] arr) {
        //判断长度
        if(arr.length <= 1) return;
        for(int i = 0; i < arr.length-1; i++) {
            // 是否需要提前结束冒泡的标识
            boolean flag = true;
            for(int j = 0; j < arr.length-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = false;
                }
            }
            //如果本轮冒泡没有元素交换，则数组已经有序
            if(flag) break;
        }
    }

    /**
     * 插入排序
     *     将数组中的数据分为两个区间，已排序区间和未排序区间。初始已排序区间只有数组的第一个元素。
     *     每次迭代，记录待排的元素，在已排序区间中找到合适的插入位置将其插入，并保证已排序区间数据一直有序。
     * 评价
     *     最好有序 时间O(N); 最坏倒序 时间O(N²); 空间O(1); 稳定排序
     */
    private static void InsertSort(int[] arr) {
        int i,j;
        if(arr.length <= 1) return;
        //arr[0]是已排序区间，从arr[1]开始遍历未排序区间
        for(i = 1; i < arr.length; i++) {
            //待排序元素
            int current = arr[i];
            //已排序区间倒序遍历，找到顺序错误的位置时终止
            //j是已排序区间的末尾，待确认的位置是j+1
            for(j = i-1; j >= 0 && current < arr[j]; j--) {
                //如果顺序正常，元素后移一位（已排区间扩大1）
                 arr[j+1] = arr[j];
            }
            arr[j+1] = current;
        }
    }

    /**
     * 选择排序
     *     也把序列分为已排/未排两个区间，初始已排序区间为空。
     *     每次迭代，从未排序序列中找到最小的元素，放到已排序序列的末尾
     * 评价
     *     每次迭代都要遍历找最小元素，时间总是O(N²); 空间O(1)；不稳定，因为每个迭代轮次需要交换位置
     */
    private static void SelectSort(int[] arr) {
        if(arr.length <= 1) return;
        for(int i = 0; i < arr.length-1; i++) { //-1可有可无，因为只剩最后一个元素时可以不排
            //找到未排序区间的最小值的下标
            int maxIndex = i;
            for(int j = i; j < arr.length; j++) {
                if(arr[j] < arr[maxIndex])
                    maxIndex = j;
            }
            //将未排最小元素 和 当前元素 交换
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
        }
    }

    /**
     * 归并排序
     *     分治思想：要排序一个数组，把数组从中间分成前后两部分，分分别排序，再将排好序的两部分合并在一起
     *     递推公式：mergeSort(m，n) = merge(mergeSort(m，k),mergeSort(k+1, n)); 当 m=n 时终止
     * 评价
     *     最好最坏时间都是O(NlogN)
     *     空间O(N) 每次开辟的空间都会被及时释放，开辟的最大空间不超过n个数据大小，所以O(N)
     *     稳定性取决于合并过程，是稳定的
     */
    private static int[] MergeSort(int[] arr) {
        //递归出口
        if(arr.length <= 1) return arr;
        //拆成两部分, copyOfRange()左闭右开
        int[] left = Arrays.copyOfRange(arr,0,(arr.length/2));
        int[] right = Arrays.copyOfRange(arr,(arr.length/2),arr.length);
        //两部分分别排序
        int[] newLeft = MergeSort(left);
        int[] newRight = MergeSort(right);
        //合并
        return Merge(newLeft, newRight);

    }
    //合并两个有序数组，返回新的数组
    private static int[] Merge(int[] left, int[] right) {
        int[] newArr = new int[left.length + right.length];

        int lindex=0, rindex=0;
        //三个while，解决合并中的数组长度问题. 新数组的index=lindex + rindex
        //两数组都还有元素
        while(lindex < left.length && rindex < right.length) {
            if(left[lindex] < right[rindex]) {
                newArr[lindex + rindex] = left[lindex++];
            }else {
                newArr[lindex + rindex] = right[rindex++];
            }
        }
        //右边完了，左边还剩
        while(lindex < left.length)
            newArr[lindex + rindex] = left[lindex++];
        //左边完了，右边还剩
        while(rindex < right.length)
            newArr[lindex + rindex] = right[rindex++];

        return newArr;
    }

    /**
     * 快速排序
     *    1.从数列中挑出一个元素，称为“基准”（pivot）；
     *    2.partition：重新排序数列，得到  [左半边、pivot、右半边]
     *    3.递归地对左右分区进行快排，直到分区只有一个元素
     * 评价
     *     最好（平均分配），平均均时间O(NlogN); 最坏（基准最大或最小）O(N²)
     *     空间O(1)；不稳定
     * 与归并的异同
     *     快排与归并都利用了分治的思想，递归的代码
     *     归并的处理过程是 由下到上的由局部到整体，先处理子问题，然后再合并。
     *     快排的处理过程是 由上到下由整体到局部，先分区，然后再处理子问题。
     */
    private static void QuickSort(int[] arr, int low, int high) {
        //递归出口
        if(arr.length <= 1 || low >= high) return;
        //一次分区，得到pivot下标
        int pivotIndex = partition(arr,low,high);
        //对左边分区
        QuickSort(arr,low,pivotIndex-1);
        //对右边分区
        QuickSort(arr,pivotIndex+1,high);
    }
    //分区（一趟快排）
    private static int partition(int[] arr, int low, int high) {
        //pivot选第一个元素，临时存储
        int temp = arr[low];
        while(low<high) {
            //从右到左搜索
            while(low<high && arr[high] > temp) --high;
            arr[low] = arr[high];
            //从左到右搜索
            while(low<high && arr[low] < temp) ++low;
            arr[high] = arr[low];
        }
        //循环结束，high==low，这个位置用来放pivot
        arr[low] = temp;
        //返回pivot位置
        return low;
    }

}
