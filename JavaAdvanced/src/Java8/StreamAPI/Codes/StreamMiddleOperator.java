package Java8.StreamAPI.Codes;

import Java8.Docs.Stu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamMiddleOperator {
    /*
    Stream中间操作
    1.筛选与切片
    2.映射
    3.排序
    * */
    public static void main(String[] args) {
        //test1();
        //test2();
        test3();
        //ListTest();
    }

    /*
    1.筛选与切片
        filter(Predicate p)     接收 Lambda，从流中排除某些元素。
        limit(n)    截断流，使其元素不超过给定数量。
        skip(n)     跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回-个空流。与limit(n)互补
        distinct()   筛选，通过流所生成元素的hashCode()和equals()去除重复元素
    * */
    static void test1(){
        List<Stu> list = Stu.getStuInstances();
        Stream<Stu> liststream = list.stream();
        //filter(Predicate p)     接收 Lambda，从流中排除某些元素。
        //练习:查询Stu表中age>20的员工信息
        liststream.filter(s -> s.getAge() > 20).forEach(System.out::println);
        System.out.println();
        //不能继续使用已经结束的Stream
        //limit(n)    截断流，使其元素不超过给定数量。
        list.stream().limit(3).forEach(System.out::println);
        //skip(n)     跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回-个空流。与limit(n)互补
        list.stream().skip(3).forEach(System.out::println);
        //distinct0   筛选，通过流所生成元素的hashCode()和equals()去除重复元素
        list.add(new Stu("tom",22));
        list.add(new Stu("tom",22));
        list.add(new Stu("tom",22));
        list.stream().distinct().forEach(System.out::println);
    }

    /*
    2.映射
        map(Function f)     接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        flatMap(Function f)  接收一个函数作为参数，将流中的每个值都换成另一个流 ，然后把所有流连接成一个流。
    * */
    static void test2(){
        //map(Function f)     接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        List<String> list = Arrays.asList("aa", "bb", "cc");
        list.stream().map(str->str.toUpperCase()).forEach(System.out::println);
        // 练习1:获取Stu姓名长度大于3的Stu姓名。
        List<Stu> list1 = Stu.getStuInstances();
        Stream<String> nameStream = list1.stream().map(e -> e.getName());
        nameStream.filter(name->name.length()>3).forEach(System.out::println);
        //练习2
        Stream<Stream<Character>> streamStream = list.stream().map(StreamMiddleOperator::fromStringtoStream);
        streamStream.forEach(s->s.forEach(System.out::println));
        //flatMap(Function f)  接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
        //map和flatMap差别就和List的add()方法和addAll()方法一样，add()是整个把List当作一个对象整体放进list，
        // 而addAll()是把List集合中每个元素放入List
        Stream<Character> characterStream = list.stream().flatMap(StreamMiddleOperator::fromStringtoStream);
        characterStream.forEach(System.out::println);
    }
    /*
    3.排序
        sorted()    产生一个新流，其中按自然顺序排序
        sorted(Comparator com)      产生一个新流，其中按比较器顺序排序（定制排序）
    * */
    static void test3(){
        List<Integer> list = Arrays.asList(1,5,-54,8,6,7,9);
        list.stream().sorted().forEach(System.out::println);

        List<Stu> stuList = Stu.getStuInstances();
        //抛异常，原因: Stu没有实现Comparable接F
        //stuList.stream().sorted().forEach(System.out::println);
        //stuList.stream().sorted((s1,s2)->s1.getName().compareTo(s2.getName())).forEach(System.out::println);
        stuList.stream().sorted((s1,s2)->s1.getName().compareTo(s2.getName())).forEach(System.out::println);

    }
    //将字符串中的多个字符构成的集合转换为对应的Stream的实例
    public static Stream<Character> fromStringtoStream(String str){
        List<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }
    static void ListTest(){
        List l1 = new ArrayList();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        List l2 = new ArrayList();
        l2.add(4);
        l2.add(5);
        l2.add(6);
        //l1.add(l2);//    [1, 2, 3, [4, 5, 6]]
        l1.addAll(l2);//   [1, 2, 3, 4, 5, 6]
        System.out.println(l1);
    }
}
