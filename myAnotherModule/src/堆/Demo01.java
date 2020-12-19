package 堆;

/**
 * 堆
 *     - 定义：1.完全二叉树 2.每个节点的值都大于等于（或小于等于）子树中每个节点的值
 *     - 存储结构：因为是完全二叉树，使用数组来存储比较节省空间
 *     - 应用: 堆排序
 *
 *
 */
public class Demo01 {
    public static void main(String[] args) {
        Heap heap = new Heap(15);
        int[] n = {2,7,3,5,1,6,8,9};

        for(int a : n) {
            heap.insert(a);
            System.out.println(heap);
        }

        heap.removeMax();
        System.out.println(heap);

        //堆排测试
        heapSort(n);
        for(int a : n){
            System.out.print(a + ",");
        }

    }
    /**
     * 堆排序:
     *     1.先对无序数组进行【建堆】：从最后一棵最小子树开始，从后往前使整棵树成为堆。每个节点做自顶向下的堆化
     *     2.堆顶元素与末尾元素互换，堆长度-1
     *     3.剩下的堆，重新调整为堆
     *     不断取出堆顶元素，直到堆中只剩一个元素
     */
    public static void heapSort(int[] arr) {
        int n = arr.length-1;
        buildHeap(arr,n);

        while(n > 0) {
            int temp = arr[n];
            arr[n] = arr[0];
            arr[0] =temp;
            //堆长-1，并将剩下的部分重新调整为堆
            Heap.heapifyTop2Bottom(arr,0,--n);
        }
    }
    //从最后一棵最小子树开始建堆，每个节点做一次【自顶向下的堆化】
    private static void buildHeap(int[] arr, int end) {
        //从最后一个叶子的父节点开始
        for(int i = end/2; i >= 0; i--){
            Heap.heapifyTop2Bottom(arr,i,end);
        }
    }
}
