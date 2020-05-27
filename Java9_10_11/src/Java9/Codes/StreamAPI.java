package Java9.Codes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(23,45,26,31,59,67,54,92,38);
        //takeWhile返回从开头开始的按照指定规则尽量多的元素
        list.stream().takeWhile(s->s<59).forEach(System.out::println);
        System.out.println();
        //与takeWhile相反，返回剩余的元素。
        list.stream().dropWhile(s->s<59).forEach(System.out::println);
//        Stream<Integer> integerStream = Stream.of(1, 2, 3,null);
//        integerStream.forEach(System.out::println);
//        //Stream.of()参数中的多个元素，可以包含null值,不能只有一个唯一元素为null
//        //Stream<Integer> integerStream1 = Stream.of(null);
//        Stream<Integer> integerStream2 = Stream.of(null,null);
//        integerStream2.forEach(System.out::println);
        Integer i = 10;
        i = null;
        //ofNulLabLe(): 形参变量是可以为nuLl值的单个元素
        Stream<Integer> integerStream1 = Stream.ofNullable(i);
        System.out.println(integerStream1.count());

        Stream.iterate(0,s->s+1).limit(10).forEach(System.out::println);
        //java9中新增的重载的方法
        Stream.iterate(0,s->s<10,s->s+1).forEach(System.out::println);
    }
}
