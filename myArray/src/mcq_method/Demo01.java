package mcq_method;

/*
 * 方法的定义和调用
 */
public class Demo01 {
    public static void main(String[] args) {
        //调用方法
        isEvenNum();

    }

    //方法定义
    public static void isEvenNum(){
        int num = 10;
        if(num%2 == 0){
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
