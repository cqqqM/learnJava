package 集合.Map;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * 键盘录入字符，输出"a(5)b(4)c.txt(3)d(2)e(1)"
 */
public class HashMapWordCountDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String line = sc.nextLine();

        //创建HashMap集合，键是字符，值是出现次数
//        HashMap<Character, Integer> hm = new HashMap<>();
        TreeMap<Character, Integer> hm = new TreeMap<>(); //用TreeMap改进

        //遍历字符串，得到每一个字符
        for(int i = 0; i < line.length(); i++) {
            char key = line.charAt(i);

            if( ! hm.containsKey(key)) { //没有这个键，则增加这个键，值为1
                hm.put(key,1);
            } else { //这个键已存在，则对应的值+1
                Integer value = hm.get(key);
                hm.put(key,value+1);
            }
        }

        //遍历hm集合，按要求拼接输出
        Set<Character> keySet = hm.keySet();
        for(Character key : keySet){
            Integer value = hm.get(key);
            System.out.print(key + "(" + value + ")");
        }
    }
}
