package Java8.StreamAPI.Codes;

import Java8.Docs.Stu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreate {
    /*
    1. Stream. 关注的是对数据的运算，与CPU打交道
        集合关注的是数据的存储，与内存打交道
    2.
        ①Stream自己不会存储元素。
        ②Stream不会改变源对象。相反，他们会返回一一个持有结果的新Stream。
        @Stream操作是延迟执行的。这意味着他们会等到需要结果的时候才执行
    3.Stream执行流程
        ①Stream 的实例化
        ②一系列的中间操作(过滤、映射、...)
        ③终止操作
    4.说明:
        4.1 -个中间操作链，对数据源的数据进行处理
        4.2 -旦执行终止操作，就执行中间操作链，并产生结果。之后，不会再被使用

    */
    public static void main(String[] args) {

    }
    //创建Stream方式一:通过集合
    static void test1(){

        List<Stu> list = new ArrayList<>();
        //default Stream<E> stream() :返回一个顺序流
        Stream<Stu> stream = list.stream();
        //default Stream<E> parallelStream() :返回一个并行流
        Stream<Stu> stuStream = list.parallelStream();
    }
    //创建Stream方式二:通过数组
    static void test2(){

        int arr[] = new int[]{1,2,3,4,5};
        //调用Arrays类的static <T> Stream<T> stream(T[] array):返回一个流
        IntStream intstream = Arrays.stream(arr);
        Stu[] stus = new Stu[]{new Stu("tom"),new Stu("jry")};
        Stream<Stu> stustream = Arrays.stream(stus);
    }
    //创建Stream方式三:通过Stream的of()
    static void test3(){
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);

    }
    //创建Stream方式四：创建无限流。
    static void test4(){
        //迭代 public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        //遍历前十个偶数
        Stream.iterate(0,t->t+2).limit(10).forEach(System.out::println);
        //生成  public static<T> Stream<T> generate(Supplier<T> s)
        //生成十个随机数
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

    }
}
