package Java9.Codes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class OptionalTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Tom");
        list.add("Jerry");
        list.add("Tim");
        Optional<List<String>> list1 = Optional.ofNullable(list);
        Stream<List<String>> stream = list1.stream();
//        long count = stream.count();
//        System.out.println(count); 1
        stream.flatMap(s->s.stream()).forEach(System.out::println);


    }
}
