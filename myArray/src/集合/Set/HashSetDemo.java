package 集合.Set;

import java.util.HashSet;

/** HashSet：Set接口的实现类
 *     底层数据结构是哈希表HashMap
 *     对集合的迭代顺序不作保证
 *     默认初始长度16
 *
 * 如何保证不重复？
 *     调用对象的hashCode()方法--根据hash值计算对象存储位置
 *         该位置没有元素，则存储到该位置
 *         该位置有元素，比较该位置的元素与新加入的元素是否相同：hashCode()、equals()，重复则不存
 *
 *
 */
public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();
        hs.add("hello");
        hs.add("world");
        hs.add("java");
        //不包含重复元素
        hs.add("world");

        for(String s : hs){
            System.out.println(s);
        }

    }
}
