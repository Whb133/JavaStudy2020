package Java8.StreamAPI.Codes;

import Java8.Docs.Stu;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEndOperator {
    /*
   Stream终止操作
       1.匹配和查找
       2.归约
       3.收集
   * */
    public static void main(String[] args) {
        //test11();
        //test12();
        //test2();
        test3();
    }
    /*
    1.匹配与查找
    allMatch(Predicate p)       检查是否匹配所有元素
    anyMatch(Predicate p)       检查是否至少匹配-一个 元素
    noneMatch(Predicate p)      检查是否没有匹配所有元素
    findFirst()                 返回第一个元素
    findAny()                   返回当前流中的任意元素
    * */
    static void test11(){
        List<Stu> list = Stu.getStuInstances();
        //allMatch(Pradicate p)- 检查是否匹配所有元素。
        // 练习:是否所有的Stu的年龄都大于23
        boolean allMatch = list.stream().allMatch(stu -> stu.getAge() > 23);
        System.out.println(allMatch);
        //anyMatch(Predicate p)-检查是否至少匹配一个元素。
        // 练习:是否存在Stu的年龄大于30
        boolean anyMatch = list.stream().anyMatch(stu -> stu.getAge() > 30);
        System.out.println(anyMatch);
        //noneMatch(Predicate p)-检查是否没有匹配的元素。
        // 练习:是否存在Stu以“J”开头
        boolean noneMatch = list.stream().noneMatch(stu -> stu.getName().startsWith("J"));
        System.out.println(noneMatch);
        //findFirst-返回第一个元素
        Optional<Stu> first = list.stream().findFirst();
        System.out.println(first);
        //findAny-返回当前流中的任意元素
        Optional<Stu> any = list.parallelStream().findAny();
        System.out.println(any);
    }
    /*
    1.匹配与查找(续)
    count()             返回流中元素的总个数
    max(Comparator c)   返回流中最大值
    min(Comparator c)   返回流中最小值
    forEach(Consumer c) 内部迭代
    * */
    static void test12(){
        List<Stu> list = Stu.getStuInstances();
        //count--返回流中 元素的总个数
        long count = list.stream().filter(stu -> stu.getAge() > 25).count();
        System.out.println(count);
        //max(Comparator c)-返回流中最大值
        //练习:返回最高的Age:
//        list.stream().max(new Comparator<Stu>() {
//            @Override
//            public int compare(Stu o1, Stu o2) {
//                return Integer.compare(o1.getAge(),o2.getAge());
//            }
//        });
        Optional<Stu> max = list.stream().max((s1, s2) -> Integer.compare(s1.getAge(), s2.getAge()));
        System.out.println(max);
        //map()映射，此时映射为具体的ageStream
        Optional<Integer> max1 = list.stream().map(stu -> stu.getAge()).max(Integer::compareTo);
        System.out.println(max1);
        //min(Comparator c)-返回流中最小值
        //练习:返回最低Age的Stu
        Optional<Stu> min = list.stream().max((s1, s2) -> -Integer.compare(s1.getAge(), s2.getAge()));
        System.out.println(min);
        //forEach(Consumer c)-内部迭代。
        // 内部迭代(使用Collection 接口需要用户去做迭代，称为外部迭代。相反，Stream API使用内部迭代,它邦你把迭代做了)
        list.stream().forEach(System.out::println);
        System.out.println();
        //使用集合的遍历操作，default
        list.forEach(System.out::println);
    }
    /*
    2.归约
    reduce(T iden, BinaryOperator b)    可以将流中元素反复结合起来，得到一个值。返回T
    reduce(BinaryOperator b)    可以将流中元素反复结合起来，得到一个值。返回Optional<T>
        备注: map和reduce的连接通常称为map-reduce模式，因Google用它来进行网络搜索而出名。
    * */
    static void test2(){
        //reduce(T iden, BinaryOperator b)    可以将流中元素反复结合起来，得到一个值。返回T
        //练习：计算1-10自然数的和
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer arrreduce = arr.stream().reduce(0, Integer::sum);
        System.out.println(arrreduce);
        //reduce(BinaryOperator b)    可以将流中元素反复结合起来，得到一个值。返回Optional<T>
        //练习：计算所有Stu年龄和
        List<Stu> list = Stu.getStuInstances();
//        Stream<Integer> integerStream = list.stream().map(Stu::getAge);
//        Optional<Integer> reduce = integerStream.reduce((i1, i2) -> i1 + i2);
//        System.out.println(reduce);
        Optional<Integer> stureduce = list.stream().map(Stu::getAge).reduce(Integer::sum);
        //get()方法必须保证原来数据非空，否则会报异常  NoSuchElementException("No value present")
        System.out.println(stureduce.get());
    }
    /*
    3.收集
    collect(Collector c)    将流转换为其他形式。接收一个Collector接口的实现，用于给Stream中元素做汇总的方法
        Collector接口中方法的实现决定了如何对流执行收集的操作(如收集到List、Set、Map)。
        另外，Collectors 实用类提供了很多静态方法，可以方便地创建常见收集器实例，具体方法与实例如下表:

    * */
    static void test3(){
        //collect(Collector c)    将流转换为其他形式。接收一个Collector接口的实现，用于给Stream中元素做汇总的方法
        //练习：查找年龄大于20的Stu，结果返回一个List或Set
        List<Stu> list = Stu.getStuInstances();
        List<Stu> collect = list.stream().filter(stu -> stu.getAge() > 20).collect(Collectors.toList());
//        Iterator<Stu> iterator = collect.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
        collect.forEach(System.out::println);

    }
}
