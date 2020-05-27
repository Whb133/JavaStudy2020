package JavaCommomClass.DatePractice.Beforejdk8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {
    /*
    对日期Date格式化和解析。
    格式化：日期 ---> 字符转
    解析（格式化逆过程）： 字符转 ---> 日期
    * */
    public static void main(String[] args) throws ParseException {

        //创建SimpleDateFormat对象
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        //创建Date对象
        Date date = new Date();
        System.out.println(date);
        //使用默认format对Date格式化，结果为String
        String fd = simpleDateFormat.format(date);
        System.out.println(fd);

        //使用默认format对String格式化，结果为Date
        Date date2 = simpleDateFormat.parse("20-4-14 下午4:04");
        System.out.println(date2);

        SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(myformat.format(new Date()));
        //解析时，要求字符串必须是符合SimpleDateFormat识别的格式，否则会抛出异常
        System.out.println(myformat.parse("2020-04-14 16:10:37"));

        //将字符串 "2020-04-14" 转换为java.sql.Date格式
        String str = "2020-04-14";
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        Date d2 = format1.parse(str);
        java.sql.Date sqldate = new java.sql.Date( d2.getTime()) ;
        System.out.println(sqldate);

    }
}
