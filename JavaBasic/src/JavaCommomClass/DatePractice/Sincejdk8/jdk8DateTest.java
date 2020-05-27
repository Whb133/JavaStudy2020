package JavaCommomClass.DatePractice.Sincejdk8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class jdk8DateTest {
    /*
    LocalDate、LocalTime、LocalDateTime类的使用
    类似于java.util.Calendar
    * */

    public static void main(String[] args) {

        //now  获取当前日期、时间、日期+时间
        LocalDate date =LocalDate.now();
        LocalTime time =LocalTime.now();
        LocalDateTime dateTime =LocalDateTime.now();

        System.out.println(date);
        System.out.println(time);
        System.out.println(dateTime);

        //of()  设置指定的年、月、日、时、分、秒，没有偏移量
        LocalDateTime dateTime1 = LocalDateTime.of(2020,2,28,14,30,00);
        System.out.println(dateTime1);

        //getXXX  获取相关属性
        System.out.println(dateTime.getDayOfMonth());
        System.out.println(dateTime.getDayOfYear());
        System.out.println(dateTime.getMonth());
        System.out.println(dateTime.getMonthValue());
        System.out.println(dateTime.getMinute());

        //不可变性
        //withXXX()  设置某属性值，原对象值不变，
        LocalDateTime dateTime2 = dateTime.withDayOfMonth(22);
        System.out.println(dateTime);
        System.out.println(dateTime2);

        LocalDateTime dateTime3 = dateTime.withHour(22);
        System.out.println(dateTime);
        System.out.println(dateTime3);

        LocalDateTime dateTime4 = dateTime.plusMonths(4);
        System.out.println(dateTime);
        System.out.println(dateTime4);

        LocalDateTime dateTime5 = dateTime.minusDays(10);
        System.out.println(dateTime);
        System.out.println(dateTime5);

    }
}
