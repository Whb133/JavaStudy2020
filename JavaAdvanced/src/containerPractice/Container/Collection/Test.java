package containerPractice.Container.Collection;

import java.util.*;

public class Test {

    public static void main(String[] args) {

        HashSet objects = new HashSet<>();
        objects.add(null);
        objects.add(123);
        objects.add(new User("lo",20));
        System.out.println(objects);

        System.out.println("#########################");
        HashSet objects1 = new LinkedHashSet();

        objects1.add(null);
        objects1.add(123);
        objects1.add(new User("lo",20));
        objects1.add(new User("lo",20));
        System.out.println(objects1);

        System.out.println("#########################");
        Set objects2 = new TreeSet<Integer>();
        objects2.add(123);
        objects2.add(new Integer(1));
//        objects2.add("new Object()");
        System.out.println(objects2);
    }
}
