package JavaCommomClass.DatePractice.Sincejdk8;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

public class DateTimeFormatterTest {
    /*
    相当于SimpleDateFormat
     */
    public static void main(String[] args) {
        //实例化
        //方式一：预定义的标准格式ISO_LOCAL_DATE_TIME、ISO_LOCAL_DATE、ISO_LOCAL_TIME
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime localDateTime = LocalDateTime.now();

        //格式化  日期--- >字符串
        String  str= dateTimeFormatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str);

        //解析  字符串 --> 日期
        TemporalAccessor datetime = dateTimeFormatter.parse("2020-04-14T20:31:55.075");
        System.out.println(datetime);


        //方式二：本地化相关的格式
        //ofLocalizedDateTime()  参数对应为FormatStyle.FULL、FormatStyle.LONG、FormatStyle.MEDIUM、FormatStyle.SHORT
        DateTimeFormatter dateTimeFormatter1= DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        String str2 = dateTimeFormatter1.format(localDateTime);
        System.out.println(str2);

        //ofLocalizedDate()  参数对应为FormatStyle.FULL、FormatStyle.LONG、FormatStyle.MEDIUM、FormatStyle.SHORT
        DateTimeFormatter dateTimeFormatter2= DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        String str3 = dateTimeFormatter2.format(datetime);
        System.out.println(str3);

        //自定义格式：ofPattern()
        //格式化
        DateTimeFormatter dateTimeFormatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateTimeFormatter3.format(localDateTime));
        //解析
        TemporalAccessor datetime2 = dateTimeFormatter3.parse("2020-04-14 20:45:30");
        System.out.println(datetime2);

    }
}
