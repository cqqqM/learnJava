package 常用API;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义工具类
 *  构造方法私有
 *  成员方法静态
 */
public class DateUtilsDemo {
    private DateUtilsDemo() {
    }

    ; //外界无法构造这个类

    /**
     * 把日期转为指定格式的字符串
     * 返回值类型：String
     * 参数： Date date , String format
     */
    public static String dateToString(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String s = sdf.format(date);
        return s;
    }

    /**
     * 把字符串解析为指定格式的日期
     * 返回值类型：Date
     * 参数： String s， String format
     */
    public static Date stringToDate(String s, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = sdf.parse(s);
        return date;
    }

    /**
     * 测试
     */
    public static void main(String[] args) throws ParseException {
        Date d = new Date();
        String s1 = DateUtilsDemo.dateToString(d,"yyyy年MM月dd日 HH:mm:ss");
        System.out.println(s1);

        String s = "2048-08-09 12:12:12";
        Date dd = DateUtilsDemo.stringToDate(s,"yyyy-MM-dd HH:mm:ss");
        System.out.println(dd);
    }
}
