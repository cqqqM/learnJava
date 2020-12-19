package mcq_ArrayList;

/*
 * 存储字符串并遍历
 */
import java.util.ArrayList;

public class Demo02Str {
    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<>();
        array.add("Mcq");
        array.add("zyk");
        array.add("mtj");

        //遍历集合通用格式
        for (int i = 0; i < array.size(); i++) {
            String s = array.get(i);
            System.out.println(s);
        }
    }
}
