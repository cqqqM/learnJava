package Lambda表达式.函数式接口;

/**
 * Supplier接口练习：获取int数组最大值
 */

import java.util.function.Supplier;

public class SupplierTest {
    public static void main(String[] args) {
        int[] arr = {10,9,10,28,37,46};
        int maxValue = getMax(() -> {
            int max = arr[0];
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
            return max;
        });
    }


    static int getMax(Supplier<Integer> sup) {
        return sup.get(); //具体的实现动作由lambda表达式完成
    }
}
