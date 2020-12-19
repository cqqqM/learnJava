package 常用API;

public class SystemDemo {
    public static void main(String[] args) {
        /*************  public static long currentTimeMillis()
         返回当前时间（以毫秒为单位）************/
        System.out.println(System.currentTimeMillis());

        //case
        System.out.println("距1970年" + System.currentTimeMillis()* 1.0/1000/60/60/24/365 + "年");

        long start = System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            System.out.println(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("共耗时" + (end - start));

        /**public static void exit(int status)
        终止当前运行的Java虚拟机。 该参数作为状态代码; 按照惯例，非零状态码表示异常终止。*/
        System.out.println("JVM马上停止");
        System.exit(0);

    }
}
