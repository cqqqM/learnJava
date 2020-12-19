package 字符串匹配和查找;

/**
 * 字符串匹配算法
 *     - 应用：java中的indexOf()  startWith()  endWith() 等方法的底层依赖
 *     - 单模式：一个串和一个串匹配：BF、RF、BM、KMP
 *     - 多模式：一个串中同时查找多个串：Trie 树、 AC自动机
 *
 * BF算法
 *     brute force 朴素匹配算法，简单暴力，从头比到尾。非常常用
 *     最坏时间 O(n * m)
 *
 * RK算法
 *     - 升级版的BF算法，引入了哈希算法：
 *         对主串中的 n-m+1 个子串分别求哈希值，然后逐个与模式串的哈希值比较大小。
 *     - 如何设计字符串的哈希函数：
 *
 *     - 时间复杂度分析：
 *         1.计算子串哈希值：通过设计的哈希算法，扫描一次主串就能得出所有子串的哈希值 O(n)
 *         2.模式串哈希值与子串哈希值作比较：哈希值一次比较O(1)，共n-m+1次，所以复杂度也是O(n)
 */
public class Demo01 {
    public static void main(String[] args) {
        String a = "你好阿斯顿那时的比如波斯的妇女";
        String b = "妇女";
        System.out.println(bf(a,b));
    }

    /**
     * BF算法 在主串t中匹配模式串p，返回主串中匹配到的开始下标，没有匹配返回-1
     * @param t
     * @param p
     * @return
     */
    public static int bf(String t, String p) {
        if (t == null || t.length() == 0 || p == null || p.length() == 0 || p.length() > t.length()) {
            return -1;
        }
        // 将单一字符串转换成数组
        char[] t_array = t.toCharArray();
        char[] p_array = p.toCharArray();
        return match(t_array,p_array);
    }
    private static int match(char[] t, char[] p) {
        int i =0;// 主串下标
        int j=0;// 模式串下标

        //遍历主串
        while(i< t.length && j < p.length){
            if(t[i] == p[j]){ // 如果匹配则目标串和模式串进行下一个字符的匹配
                i++;
                j++;
            }else {// 如果匹配不成功，则从目标字符串的下一个位置开始，重新匹配
                i = i-j+1;
                j=0;
            }
        }

        if(j == p.length)
            return i - j;
        else
            return -1;
    }

    /**
     * RK算法
     *
     */
}
