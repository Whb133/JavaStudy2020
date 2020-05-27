package Java8.ConstructorReference.Codes;

import Java8.Docs.Stu;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReTest {
    /*
    一.构造器引用
        和方法引用类似，函数式接口的抽象方法的形参列表和构造器的形参列表一致。
            抽象方法的返回值类型即为构造器所属的类的类型
    二.数组引用
        大家可以把数组看做是一个特殊的类，则写法与构造器引用一致。
    * */
    public static void main(String[] args) {
        test1();
        System.out.println();
        test2();
        System.out.println();
        test3();
        System.out.println("***************");
        arrtest1();
    }
    //构造器引用
    //Supplier中的T get()
    //EmpLoyee的空参构造器: Employee()
    static void test1(){
        Supplier<Stu> supplier = new Supplier() {
            @Override
            public Stu get() {
                return new Stu();
            }
        };
        System.out.println(supplier.get()+" normal");

        Supplier<Stu> supplier1 = ()->new Stu();
        System.out.println(supplier1.get()+" lambda");
        Supplier<Stu> supplier2 = Stu::new;
        System.out.println(supplier2.get()+" Reference");
    }
    //Function中的R apply(T t)
    static void test2(){
        Function<String,Stu> function = new Function<String, Stu>() {
            @Override
            public Stu apply(String str) {
                return new Stu(str);
            }
        };
        System.out.println(function.apply("normal").getName());

        Function<String,Stu> function1 = s->new Stu(s);
        System.out.println(function1.apply("lambda").getName());
        Function<String,Stu> function2 = Stu::new;
        System.out.println(function2.apply("Reference").getName());
    }
    //BiFunction中的R apply(T t,U u)
    static void test3(){
        BiFunction<String,Integer,Stu> biFunction = (name, age)->new Stu(name,age);
        System.out.println(biFunction.apply("lambda", 21).getName());
        BiFunction<String,Integer,Stu> biFunction1 = Stu::new;
        System.out.println(biFunction1.apply("Reference", 33).getName());
    }

    //数组引用
    //Function中的R apply(T t)
    static void arrtest1(){
        Function<Integer,String[]> func1 = length -> new String[length];
        String[] arr1 = func1.apply( 5);
        System.out.println(Arrays. toString(arr1));

    }

}
