package Java9.Codes;

import java.util.ArrayList;
import java.util.Comparator;

public class diamondOperator {
    public static void main(String[] args) {
        Comparator<Object> com = new Comparator<>(){
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };
        //jdk1.8中如果后面泛型不写的话，会报错Cannot use“<>”with anonymous inner classes，
        //与匿名实现类共同使用钻石操作符(diamondoperator)在Java8中如上的操作是会报错的，<>必须加上Object，如下
        /*Comparator<Object> com1 = new Comparator<Object>(){
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };*/

        //jdk1.7新特性：类型推断
        ArrayList<String> list = new ArrayList<>();
    }
}
