package JavaCommomClass.DatePractice.Sincejdk8;

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * @author whb
 * @date 2020/5/30-12:47
 * @
 */
public class DateClassTest {
    public static void main(String[] args) {
        //testLocalDateNow();
        //testLocalDateOf();
        //testisAfter();
        //testLeepYear();
        //testPeriod();
        testChronoUnit();

    }
    public static void testLocalDateNow(){
        LocalDate localdate = LocalDate.now();
        System.out.println("当前日期"+localdate);
        Month month = localdate.getMonth();
        System.out.println("获取月份 "+month);
        LocalTime localTime = LocalTime.now();
        System.out.println("当前时间 "+localTime);
        int minute = localTime.getMinute();
        System.out.println("获取分钟 "+minute);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("当前日期和时间 "+localDateTime);
        Month month1 = localDateTime.getMonth();
        System.out.println("既能获取月份 "+month1);
        int hour = localDateTime.getHour();
        System.out.println("还能获取小时  "+hour);
    }
    public static void testLocalDateOf(){
        LocalDate date = LocalDate.of(2020, 5, 30);
        LocalDate now = LocalDate.now();
        System.out.println(now .equals(date));
    }
    public static void testisAfter(){
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.isAfter(localDate.minusDays(1)));
    }
    public static void testLeepYear(){
        LocalDate now = LocalDate.now();
        System.out.println(now.isLeapYear());
    }
    public static void testPeriod(){
        LocalDate now = LocalDate.now();
        LocalDate bi = LocalDate.of(1997, 10, 22);
        Period beweenDays = Period.between(bi, now);
        System.out.println(beweenDays);

        LocalDate d1 = LocalDate.of(2000, 1, 1);
        LocalDate d2 = LocalDate.of(2020, 6, 13);
        Period p1 = Period.between(d1,d2);//P20Y5M12D
        System.out.println(p1.getDays());//3
        System.out.println(p1);
    }
    public static void testChronoUnit(){
        LocalDate d1 = LocalDate.of(2000, 1, 1);
        LocalDate d2 = LocalDate.of(2020, 6, 13);
        long betweenDays = ChronoUnit.DAYS.between(d1, d2);
        System.out.println(betweenDays);//7469
    }
}
