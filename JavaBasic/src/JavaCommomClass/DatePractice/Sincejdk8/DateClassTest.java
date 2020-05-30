package JavaCommomClass.DatePractice.Sincejdk8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author whb
 * @date 2020/5/30-12:47
 * @
 */
public class DateClassTest {
    public static void main(String[] args) {
        testLocalDate();

    }
    public static void testLocalDate(){
        LocalDate localdate = LocalDate.now();
        System.out.println("当前日期"+localdate);
        LocalTime now = LocalTime.now();
        System.out.println("当前时间 "+now);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("当前日期和时间 "+localDateTime);
    }
}
