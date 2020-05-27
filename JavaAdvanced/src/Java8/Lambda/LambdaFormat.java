package Java8.Lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

public class LambdaFormat {
    /*
    Lambda表达式的使用: (分为6种情况介绍)
        --1 //语法格式一:无参，无返回值   (RunnnableTest)
        --2 //语法格式二: Lambda 需要-一个参数，但是没有返回值 （ConsumerTest）
        --3 //语法格式三:数据类型可以省略，因为可由编译器推断得出，称为“类型推断户 (ConsumerTestP)
        --4 //语法格式四: Lambda 若只需要一-个参数时，参数的小括号可以省略 （ConsumerTestPP）
        --5 //语法格式五: Lambda 需要两个或以上的参数，多条执行语句，并且可以有返回值 （ComparatorTest）
        --6 //语法格式六:当Lambda体只有一条语句时，return与大括号若有，都可以省略 (ComparatorTestP)
    */
    public static void main(String[] args) {
        LambdaFormat.RunnnableTest();
        LambdaFormat.ConsumerTest();
        LambdaFormat.ConsumerTestP();
        LambdaFormat.ConsumerTestPP();
        LambdaFormat.ComparatorTest();

    }

    //语法格式一:无参，无返回值
    static void RunnnableTest() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable!");
            }
        };
        r1.run();

        System.out.println("**************");
        //Lambda表达式形式
        Runnable r2 = () -> System.out.println("Runnable!Lambda");
        r2.run();
    }

    //语法格式二: Lambda 需要-一个参数，但是没有返回值
    static void ConsumerTest(){
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("hello 1");
        System.out.println("*****************");
        Consumer<String> consumer1 = (String s)-> System.out.println(s);
        consumer1.accept("hello lambda");
    }

    //语法格式三:数据类型可以省略，因为可由编译器推断得出，称为“类型推断户
    static void ConsumerTestP(){

        Consumer<String> consumer1 = (String s)-> System.out.println(s);
        consumer1.accept("hello lambdap");
        System.out.println("*****************");
        Consumer<String> consumer2 = (s)-> System.out.println(s);
        consumer2.accept("类型推断p！！！");

        ArrayList<String> list = new ArrayList<>();//类型推断
        int[] arr = {1,2,3};//类型推断
    }

    //语法格式四: Lambda 若只需要一-个参数时，参数的小括号可以省略
    static void ConsumerTestPP(){
        Consumer<String> consumer1 = (s)-> System.out.println(s);
        consumer1.accept("类型推断pp！！！");
        System.out.println("***************");
        Consumer<String> consumer2 = s-> System.out.println(s);
        consumer2.accept("省略了（）pp");
    }

    //语法格式五: Lambda 需要两个或以上的参数，多条执行语句，并且可以有返回值
    static void ComparatorTest(){
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);;
                return Integer.compare(o1,o2);
            }
        };
        System.out.println(comparator.compare(12, 21));
        System.out.println("********************");
        Comparator<Integer> comparator1 = (o1, o2) ->{
                System.out.println(o1);
                System.out.println(o2);;
                return Integer.compare(o1,o2);
            };
        System.out.println(comparator1.compare(54, 21));
    }

    //语法格式六:当Lambda体只有一条语句时，return 与大括号若有， 都可以省略i
    static void ComparatorTestP(){
        Comparator<Integer> comparator1 = (o1, o2) ->{
            System.out.println(o1);
            System.out.println(o2);;
            return Integer.compare(o1,o2);
        };
        System.out.println(comparator1.compare(54, 21));
        System.out.println("**********************");
        Comparator<Integer> comparator2 = (o1, o2) -> Integer.compare(o1,o2);
        System.out.println(comparator2.compare(54, 21));
    }
}
