package JavaCommomClass.ComparePractice;

import java.util.Comparator;
import java.util.TreeSet;

public class ComparatorTest {
    public static void main(String[] args) {

        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User){
                    return -((User) o1).name.compareTo(((User) o2).name);
                }else {
                    throw new RuntimeException("数据类型不匹配！");
                }

            }
        };
        TreeSet treeSet = new TreeSet(comparator);
        treeSet.add(new User("jack",20));
        treeSet.add(new User("tom",28));
        treeSet.add(new User("jerry",24));
        treeSet.add(new User("tim",25));
        treeSet.add(new User("loris",27));
        System.out.println(treeSet);
    }
}
