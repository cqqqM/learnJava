package mcq_String;

/*
 * 将数组拼接成字符串
 */
public class CharJoint {
    public static void main(String[] args) {
        int[] arr = {10, 2, 3};
        System.out.println("遍历数组，拼接: "+ array2String(arr));
        //System.out.println("遍历数组，存入char数组，创建String对象: " + arr2str(arr));


    }

    public static String array2String(int[] arr) {
        String s = "";
        s += "[";

        for (int i = 0; i < arr.length; i++) {
            if(i == arr.length-1) { //最后一个元素
                s += arr[i];
            } else {
                s += arr[i];
                s += ", ";
            }
        }
        s += "]";
        return  s;
    }

//    public static String arr2str(int [] arr){
//        char[] ch = new char[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            ch[i] = (char)arr[i];
//            System.out.println(ch[i]);
//        }
//        String s = new String(ch);
//        System.out.println(s);
//        return s;
//    }
}
