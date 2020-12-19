package 堆;

import java.util.Arrays;

public class Heap {
    //存储元素的数组
    private int[] data;
    //堆中可存储数据的最大个数
    private int size;
    //堆中已存元素个数
    private int count;

    public Heap(int capacity) {
        //从下标为1处开始存储
        this.data = new int [capacity + 1];
        this.size = capacity;
        this.count = 0;
    }

    @Override
    public String   toString() {
        return "Heap{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                ", count=" + count +
                '}';
    }

    /**
     * 插入元素
     *     将新元素放置树的末尾，然后重新调整为堆
     */
    public void insert(int data) {
        if(count == size) //堆已满
            return;
        //插入数据
        this.data[++count] = data;
        //堆化
        heapifyBottom2Top(this.data, count);

    }

    /**
     * 自底向上的堆化：如果当前元素大于其父，则交换
     */
    private void heapifyBottom2Top(int[] data, int end) {
        int i = end;
        while(i / 2 > 0 && data[i] > data[i/2]) { //当前元素 大于 父节点
            int temp = data[i];
            data[i] = data[i/2];
            data[i/2] = temp;
            i = i / 2;
        }
    }

    /**
     * 删除堆顶元素
     *     为了防止完全二叉树删除元素后，数组“不满”
     *     将堆尾的元素交换到堆顶，然后重新调整为堆，舍弃掉堆尾即可
     */
    public int removeMax() {
        int max = data[1];

        //堆尾元素拿到堆顶，舍弃最后一个位置
        data[1] = data[count--];
        heapifyTop2Bottom(data,1,count);

        return max;
    }

    /**
     * 自顶向下的堆化：如果当前元素小于其孩子，需要找到三者中最大的节点做交换
     */
    public static void heapifyTop2Bottom(int[] data, int begin, int end) {
        while(true) {
            //i记录最大值的下标，每次迭代只在三个节点之内判断
            int i = begin;
            //找出当前节点及左右孩子的最大值
            if(begin*2 <= end && data[i] < data[begin*2]) //与左孩子对比
                i = begin*2;
            if(begin*2+1 <= end && data[i] < data[begin*2+1]) //与右孩子对比
                i = begin*2 + 1;

            //当前节点最大，没有做交换，结束循环
            if(begin == i) {
                break;
            }
            //发现了最大值，交换到父亲，对该孩子继续进行堆化
            else {
                int temp = data[i];
                data[i] = data[begin];
                data[begin] = temp;
                //继续往下堆化
                begin = i;
            }
        }
    }

}
