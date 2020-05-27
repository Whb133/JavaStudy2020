package Java8.FuncationalInterface.Core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("公鸡", "母鸡", "飞机");
        List<String> list1 = filterList(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("鸡");
            }
        });
        System.out.println(list1);
        System.out.println("******************");
        List<String> list2 = filterList(list, s -> s.contains("机"));
        System.out.println(list2);

    }

    //根据给定的规则，过滤集合中的字符串。此规则由Predicate的方法决定
    static List<String> filterList(List<String> list, Predicate<String> predicate){
        ArrayList<String> filter = new ArrayList<>();
        for (String s : list) {
            if (predicate.test(s)) {
                filter.add(s);
            }
        }
        return filter;
    }
}
