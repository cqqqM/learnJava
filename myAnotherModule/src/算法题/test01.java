package 算法题;


import java.util.Arrays;

public class test01 {
    /**
     * 合并重叠的区间
     *
     * 示例 1:
     * 输入: [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     *
     * 示例 2:
     * 输入: [[1,4],[4,5]]
     * 输出: [[1,5]]
     * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
     *
     */
    public static int[][] merge(int[][] intervals) {
        // 先按照intervals[0]排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        // 遍历区间
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval: intervals) {
            // 如果是第一个数组，直接加入res
            // 如果当前的L > res当前的R ，直接加入res
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                // 反之将当前区间合并至结果数组的最后区间
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1); //丢掉数组中多余的0
    }
    private static void exec01() {
        int[][] arr = new int[][] {{1,3},{2,6},{15,18},{8,10}};
        int[][]res = merge(arr);
        System.out.print("[");
        for(int[] i :res) {
            System.out.print("[");
            for(int j:i){
                System.out.print(j + ",");
            }
            System.out.print("]，");
        }
        System.out.print("]");
    }

    /**
     * 原地矩阵转置
     * 思路：对于矩阵中第i行的第j个元素，在旋转后，它出现在倒数第i列的第j个位置。即 matrix[row][col] 转到 matrix[col][n−row−1]
     *
     * 使用temp暂存 ,完成4个元素的原地交换
     *
     * 旋转的位置：左上角四分之一的位置。n为偶数/n为奇数
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
//        exec01();
    }


}
