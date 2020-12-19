package 常用API;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SimpleDateFormat是一个具体类，用于区域设置敏感的方式 格式化和解析日期
 *
 *      年y 月M 日d 时H 分m 秒s
 *
 *      构造方法
 *      格式化  ：public final String format(Date date)  Date2String
 *      解析：    public Date parse(String source)      String2Date
 */
public class SimpleDateFormatDemo {
    public static void main(String[] args) throws ParseException {
        //Date to String
        Date d = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat(); 给定的日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
        String s = sdf.format(d);
        System.out.println(s);

        //String to Date
        String ss = "2048-08-09 11:11:11";
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dd = sdf2.parse(ss);
        System.out.println(dd);
    }
}
