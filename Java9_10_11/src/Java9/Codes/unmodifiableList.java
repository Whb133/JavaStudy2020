package Java9.Codes;

import java.util.*;

public class unmodifiableList {
    public static void main(String[] args) {
        //jdk8
        List<String> namesList = new ArrayList<>();
        namesList.add("Joe");
        namesList.add("Bob");
        namesList.add("Bill");
        //返回的namesList是-一个只读的集合
        namesList = Collections.unmodifiableList(namesList);
        //报错 java.lang.UnsupportedOperationException
        //namesList.add("yyy");
        System.out.println(namesList);
        //此时得到的集合list也是一个只读集合。
        List<Integer> list11 = Arrays.asList(1,2,3,4,5);
        //报异常java.lang.UnsupportedOperationException
        list11.add(6);


        List<String> list = Collections . unmodifiableList(Arrays.asList("a","b","c"));
        Set<String> set = Collections . unmodifiableSet (new HashSet<>(Arrays.asList("a","b", "c")));
        //如下操作不适用于jdk 8及之前版本，适用于jdk 9
        Map<String, Integer> map = Collections.unmodifiableMap( new HashMap<>() {
            {
                put("a", 1);
                put("b", 2);
                put("c", 3);
            }
        });
        map.forEach((k, v) -> System. out. println(k + " : "+ v));



        //集合工厂方法:快速创建贝读集
        List<Integer> list1 = List.of(1,2,3,4,5);
        //不能对list1进行add操作
        //list1.add(6);
        System.out.println(list);
    }

}
