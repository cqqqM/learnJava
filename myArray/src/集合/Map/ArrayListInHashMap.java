package 集合.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * HashMap集合中嵌套ArrayList
 *     HashMap<String, ArrayList<String>>
 */
public class ArrayListInHashMap {
    public static void main(String[] args) {
        //创建HashMap集合
        HashMap<String, ArrayList<String>> hm = new HashMap<>();

        //创建AL集合并添加元素，把AL集合添加到HM集合中
        ArrayList<String> al1 = new ArrayList<>();
        al1.add("刘备");
        al1.add("诸葛亮");
        hm.put("三国演义",al1);

        ArrayList<String> al2 = new ArrayList<>();
        al2.add("唐僧");
        al2.add("孙悟空");
        hm.put("西游记",al2);

        ArrayList<String> al3 = new ArrayList<>();
        al3.add("武松");
        al3.add("鲁智深");
        hm.put("水浒传",al3);

        //toString遍历
        System.out.println(hm);

        //手动遍历，
        // 外层是HashMap：获取keySet，get方法遍历得到value
        // 内层value是ArrayList：遍历内容即可
        Set<String> keySet = hm.keySet();
        for(String key : keySet){
            System.out.println(key);
            ArrayList<String> value = hm.get(key);
            for(String s : value){
                System.out.println("\t" + s);
            }
        }
    }
}
