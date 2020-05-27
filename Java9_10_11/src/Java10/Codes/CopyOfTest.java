package Java10.Codes;

import java.util.ArrayList;
import java.util.List;

public class CopyOfTest {
    public static void main(String[] args) {

        //示例1:
        var list1 = List.of("Java", "Python", "C");
        var copy1 = List.copyOf(list1);
        System. out . println(list1 == copy1); // true
        //示例2:
        var list2 = new ArrayList<String>();
        var copy2 = List. copyOf(list2);
        System. out . println(list2 == copy2); // false
        //示例1和示例2代码基本-致，为什么一个为true,一个为false?
        //结论: copyof(Xxx coll): 如果参数coll本身就是一个只读集合， 则copy0f() 返回值即为该集合本身。
        //如果参数coll不是一个只读集合，则copyOf() 返回一个新的集台，这个集合是只读的。

    }
}
