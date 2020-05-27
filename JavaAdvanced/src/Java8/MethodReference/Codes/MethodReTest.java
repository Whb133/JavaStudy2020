package Java8.MethodReference.Codes;

import Java8.Docs.Stu;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReTest {
    /*
    方法引用的使用
        1.使用情境:当要传递给L ambda体的操作，已经有实现的方法了，可以使用方法引用!
        2.方法引用，本质上就是Lambda表达式，而L ambda表达式作为函数式接口的实例。所以
            方法引用，也是函数式接口的实例。
        3.使用格式: 类(或对象) ::方法名
        4.具体分为如下的三种情况: .
            情况一    对象::非静态方法
            情况二    类::静态方法
            情况三    类::非静态方法
        5.方法引用使用的要求:
            要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的形参列表和返回值类型相同! (针对于情况1和情况2 )

    * */
    public static void main(String[] args) {
        test11();
        System.out.println();
        test12();
        System.out.println();
        test21();
        System.out.println();
        test22();
        System.out.println();
        test31();
        System.out.println();
        test32();
        System.out.println();
        test33();
    }

    //情况一:对象::实例方法
    //Consumer中的void accept(T t)
    //PrintStream中的void println(T t)
    static void test11() {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String str) {
                System.out.println(str);
            }
        };
        consumer.accept("normal");

        Consumer<String> consumer1 = str -> System.out.println(str);
        consumer1.accept("lambda");

        PrintStream printStream = System.out;
        Consumer<String> consumer2 = printStream::println;
        consumer2.accept("method reference");

    }

    //Supplier中的T get()
    //Stu中的String getName()
    static void test12() {
        Supplier<String> supplier = new Supplier() {
            @Override
            public String get() {
                return "normal";
            }
        };
        System.out.println(supplier.get());

        Stu stu = new Stu("tom");
        Supplier<String> supplier1 = () -> stu.getName();
        System.out.println(supplier1.get() + " lambda");

        Supplier<String> supplier2 = stu::getName;
        System.out.println(supplier2.get() + " method reference");
    }

    //情况二:类::静态方法
    //Comparator中的int compqre(T t1,T t2)
    //Integer中的int compare(T t1, T t2)
    static void test21() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        System.out.println(comparator.compare(57, 65) + " normal");
        Comparator<Integer> comparator1 = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(comparator1.compare(98, 59) + " lambda");
        Comparator<Integer> comparator2 = Integer::compare;
        System.out.println(comparator2.compare(35, 12) + " method reference");

    }

    //Function中的R apply(T t)
    //Math中的Long round(Double d)
    static void test22() {
        Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String str) {
                return str.length();
            }
        };
        System.out.println(function.apply("hello") + " noamal");

        Function<String, Integer> function1 = (str) -> str.length();
        System.out.println(function1.apply("nihao") + " lambda");
        Function<Double, Long> function2 = Math::round;
        System.out.println(function2.apply(1.1) + " method reference");
    }

    //情况三:类::实例方法(有难度)
    // Comparator 中的int comapre(T t1,T t2)
    // String 中的int t1.compareTo(t2)
    static void test31() {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        };
        System.out.println(comparator.compare("sad", "wqeq")+" normal");

        Comparator<String> comparator1 = (s1,s2)->s1.compareTo(s2);
        System.out.println(comparator1.compare("wqe", "dfsd")+" lambda");

        Comparator<String> comparator2 = String::compareTo;
        System.out.println(comparator2.compare("lkj", "oiu")+" method reference");
    }

    //BiPredicate中的boolean test(T t1,T t2);
    //String中的boolean t1. equals(t2)
    static void test32() {

        BiPredicate<String,String> biPredicate = (s1,s2) ->s1.equals(s2);
        System.out.println(biPredicate.test("abc", "abc"));
        BiPredicate<String,String> biPredicate1 = String::equals;
        System.out.println(biPredicate1.test("abc", "abd"));
    }
    // Function中的R apply(T t)
    // EmpLoyee 中的String getName();
    static void test33() {
        Stu st = new Stu("ton");
        Function<Stu,String> function = stu ->stu.getName();
        System.out.println(function.apply(st)+" lambda");

        Function<Stu,String> function1 = Stu::getName;
        System.out.println(function1.apply(st)+" method reference");
    }

}
