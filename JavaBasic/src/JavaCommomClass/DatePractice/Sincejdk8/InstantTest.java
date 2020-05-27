package JavaCommomClass.DatePractice.Sincejdk8;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class InstantTest {
    public static void main(String[] args) {

        //类似于java.util.Date类

        //now 获取本初子午线的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);

        //添加时间偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //获取自1970.1.1 00：00：00开始的毫秒数  相当于Date类的getTime()
        long l = instant.toEpochMilli();
        System.out.println(l);

        //通过给定的毫秒数，实例化Instant对象   相当于Date类的new Date（long millions）
        Instant instant1 = Instant.ofEpochMilli(1586866449718L);
        System.out.println(instant1);

    }
}
