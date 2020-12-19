package mcq_method;

/*
 * 带返回值的方法
 *
 */
public class Demo03 {
    public static void main(String[] args) {
        isEvenNum(10); //返回值未接收

        boolean flag = isEvenNum(10); // 接收返回值并打印
        System.out.println(flag);
    }

    public static boolean isEvenNum(int num){
        if(num%2==0){
            return true;
        } else {
            return false;
        }
    }
}


