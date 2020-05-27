package JavaCommomClass.DatePractice.Beforejdk8;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarTest {
    public static void main(String[] args) {

        /*
        1.实例化
        方式一：创建其子类对象  new GregorianCalendar();
        方式二：调用其静态方法   Calendar.getInstance();
        * */
        Calendar c = Calendar.getInstance();

        //常用方法：
        //get
        int month = c.get(Calendar.MONTH)+1;
        int wom = c.get(Calendar.WEEK_OF_MONTH);
        int doy = c.get(Calendar.DAY_OF_MONTH);

        //set
        c.set(Calendar.DAY_OF_MONTH,10);//设置当前日期为10号
        //add
        c.set(Calendar.DAY_OF_MONTH,3);//在当前日期上加上3天，-3  减去三天
        //getTime()  日历类--->Date
        Date d = c.getTime();
        //setTime()   Date--->日历类
        c.setTime(new Date());
    }
}
