package Java8.Optional;

import Java8.Docs.Stu;

import java.util.Optional;

public class OptionalTest {
    /*
    创建Optional类对象的方法:
        ➢Optional.of(T t):创建一个Optional实例，t必须非空; .
        ➢Optional.empty() :创建一个空的Optional实例.
        ➢Optional.ofNullable(T t):t可以为null
    * */
    public static void main(String[] args) {
        //easyTest();
        //test11();
        //test12();
        test13();
    }
    static void easyTest(){
        Stu s = new Stu("tom",22);
        //s = null;s不能为null，否则会报错
        Optional<Stu> optionalStu = Optional.of(s);
        System.out.println(optionalStu);
        s = null;
        //s可以是null
        Optional<Stu> s1 = Optional.ofNullable(s);
        System.out.println(s1);//结果为：      Optional.empty
    }
    static void test11(){
        //会极大概率发生NullPointerException
        Stu s1 = new Stu();
        s1 = null;
        String friendName = s1.getFriend().getName();
        System.out.println(friendName);
    }
    static void test12(){
        //加上多层判断，减少NullPointerException
        Stu s1 = new Stu();
        if (s1 != null){
            Stu friend = s1.getFriend();
            if (friend != null){
                System.out.println(friend.getName());
            }
        }
    }
    static void test13(){
        //使用Optional
        Stu stu1 = new Stu().getFriend();
        Optional<Stu> stuOptional = Optional.ofNullable(stu1);
        //orELse(T t1): 如果单前的Optional内部封装的t是非空的，则返回内部的t.
        //如果内部的t是空的，则返回orELse()方法中的参数t1.
        Stu freiend = stuOptional.orElse(new Stu("freiend"));
        System.out.println(freiend.getName());

    }

}
