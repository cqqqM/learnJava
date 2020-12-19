package 常用API;

import java.util.Calendar;

/**
 * Calendar类是一个抽象类，
 * 可以提供 某一时刻 和一组 日历字段 的转换，如YEAR ， MONTH ， DAY_OF_MONTH ， HOUR
 * 以及用于操纵该日历字段，如获取的日期下个星期。
 * 获取：Calendar rightnow = Calendar.getInstance()
 *
 * 常用方法
 * public abstract void add(int field, int amount) 根据日历的规则，将指定的时间量添加或减去给定的日历字段
 * public final void set(int year, int month, int date) 设置当前日历的年月日
 */

public class CalenderDemo {
    public static void main(String[] args) {
        //获取对象
        Calendar c = Calendar.getInstance(); //多态的形式
        System.out.println(c);

        //get()字段
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1; //月份从0开始
        int date = c.get(Calendar.DATE);
        System.out.println(year + "," + month + "," + date);

        //add()
        c.add(Calendar.YEAR,-3); //三年前
        c.add(Calendar.DATE, 10);//10天后
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH) + 1; //月份从0开始
        date = c.get(Calendar.DATE);
        System.out.println(year + "," + month + "," + date);

        //set()
        c.set(2022,7,1);



    }
}
