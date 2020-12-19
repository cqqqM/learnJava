package 集合.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Map集合的遍历方式1
 *     map.keySet()获取所有键的集合，遍历键的集合，每次获取对应的值
 *
 * Map集合遍历方式2
 *     map.entrySet()获取所有键值对的集合，遍历键值对集合，每次获取对应的键值
 *     键值对对象: Map.Entry<K,V>
 */
public class MapTraversal {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        //put(K,V) 用于增加和修改键值
        map.put("19120393", "mcq");
        map.put("19120394", "mtj");
        map.put("19120391", "lx");

        //遍历1
        Set<String> set = map.keySet();
        for (String s : set) {
            System.out.println(map.get(s));
        }

        //遍历2
        Set<Map.Entry<String, String>> set2 = map.entrySet();
        for(Map.Entry<String, String> me : set2){
            System.out.println(me.getKey() + "," + me.getValue());
        }
    }
}
