package 常用API;

import java.util.Date;

/**
 * Date类
 *      2种构造方法：Date() 日期对象
 *      2个常用方法：
 *          public long getTime() 返回当前时间戳 （1970.1.1到现在的毫秒值
 *          public void setTime(long time)
 */
public class DateDemo {
    public static void main(String[] args) {
        /**
         * public Date(): 分配一个Date对象，当前时间，精确到毫秒
         */
        Date d1 = new Date();
        System.out.println(d1);//Sat Jul 04 18:37:49 GMT+08:00 2020

        /**
         * public Date(long date)：标准时间起的毫秒值（时间戳
         */
        Date d2 = new Date(1000*60*60);
        System.out.println(d2);//Thu Jan 01 09:00:00 GMT+08:00 1970

        /**
         * getTime()
         */
        Date d3 = new Date();
        System.out.println(d3.getTime());//1593859069284

        /**
         * setTime(long time)
         */
        d3.setTime(1000*60*60);
        System.out.println(d3);//Thu Jan 01 09:00:00 GMT+08:00 1970
    }
}
