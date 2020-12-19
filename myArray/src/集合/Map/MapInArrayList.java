package 集合.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * ArrayList集合中嵌套HashMap
 *     ArrayList<HashMap<String,String>>
 *
 */
public class MapInArrayList {
    public static void main(String[] args) {
        //创建AL集合
        ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();

        //创建Map集合，作为元素加入AL集合
        HashMap<String,String> hm1 = new HashMap<>();
        hm1.put("孙策","大乔");
        hm1.put("周瑜","小乔");
        arrayList.add(hm1);

        HashMap<String,String> hm2 = new HashMap<>();
        hm2.put("郭靖","黄蓉");
        hm2.put("杨过","小龙女");
        arrayList.add(hm2);

        HashMap<String,String> hm3 = new HashMap<>();
        hm3.put("令狐冲","任盈盈");
        hm3.put("林平之","岳灵珊");
        arrayList.add(hm3);

        //toString遍历
        System.out.println(arrayList);

        //手动遍历AL集合
        for(HashMap<String,String> hm : arrayList){
            Set<String> keySet = hm.keySet();
            for(String key : keySet){
                String value = hm.get(key);
                System.out.println(key + "," + value);
            }
        }
    }
}
