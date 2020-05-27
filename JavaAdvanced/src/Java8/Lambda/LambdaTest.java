package Java8.Lambda;

import java.util.Comparator;

public class LambdaTest {
    public static void main(String[] args) {
        LambdaTest.RunnnableTest();
        LambdaTest.ComparatorTest();
    }
    static void RunnnableTest(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnanle!");
            }
        };
        r1.run();

        System.out.println("**************");
        //Lambda表达式形式
        Runnable r2 = () ->System.out.println("Runnanle!Lambda");
        r2.run();
    }
    static void ComparatorTest(){
        Comparator<Integer> comparable = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        System.out.println(comparable.compare(12, 21));

        System.out.println("*********************");
        //Lambda表达式写法
        Comparator<Integer> comparable1 = (o1,o2)->Integer.compare(o1,o2);
        System.out.println(comparable1.compare(54, 21));
        System.out.println("*********************");
        //方法引用
        Comparator<Integer> comparable2 = Integer::compare;
        System.out.println(comparable2.compare(54, 21));
    }
}
