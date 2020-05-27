package JavaCommomClass.DatePractice.Beforejdk8;

import java.util.Date;

public class DateTest {
    public static void main(String[] args) {

        //创建一个当前时间的Date对象
        Date d1 = new Date();
        System.out.println(d1.toString());
        System.out.println(d1.getTime());

        //创建一个当指定毫秒数的Date对象
        Date d2 = new Date(System.currentTimeMillis());
        System.out.println(d2);

        //创建java.sql.Date
        //java.sql.Date extends java.util.Date
        Date sqldate= new java.sql.Date(System.currentTimeMillis());
        System.out.println(sqldate);

        //sql.Date --> util.Date
        Date d3 = new Date(sqldate.getTime());
        System.out.println(d3);

        //util.Date --> sql.Date
        Date date1 = new java.sql.Date(System.currentTimeMillis());
        java.sql.Date sqldate2 = (java.sql.Date)date1;
        System.out.println(sqldate2);
    }
}
