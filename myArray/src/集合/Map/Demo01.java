package 集合.Map;

import java.util.HashMap;
import java.util.Map;

/**
 * Map集合  interface Map<K键类型,V值类型>
 *     将键映射到值的对象；不能包含重复的键；每个键可以映射到最多一个值
 *
 *     创建集合对象
 *         多态的方式，实现类HashMap
 *
 *     基本功能
 *         V put(K key, V value)
 *         V remove(Object key)
 *         void clear()
 *         boolean containsKey(Object key)
 *         boolean containsValue(Object value)
 *         boolean isEmpty()
 *         int size()
 *
 *     获取功能
 *         V get(Object key) 根据键获取值
 *         Set<K> keySet()  获取所有键
 *         Collection<V> values()  获取所有值
 *         Set<Map.Entry<K,V>> entrySet  获取所有键值对对象集合
 *
 * HashMap
 *
 * TreeMap
 *
 */
public class Demo01 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();

        //put(K,V) 用于增加和修改键值
        map.put("19120393","mcq");
        map.put("19120394","mtj");
        map.put("19120391","lx");
        System.out.println(map);//{19120391=lx, 19120394=mtj, 19120393=mcq}

        map.remove("19120393");
        System.out.println(map.containsKey("19120394"));
        System.out.println(map.containsValue("mcq"));

        System.out.println(map.size());
        //map.clear();
        System.out.println(map.isEmpty());

        /******************************/
        //获取方法
        System.out.println(map.get("19120391"));
        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(map.entrySet());

    }
}
