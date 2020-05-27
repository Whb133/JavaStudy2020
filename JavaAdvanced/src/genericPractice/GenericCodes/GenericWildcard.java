package genericPractice.GenericCodes;

import java.util.List;

public class GenericWildcard {
    public static void main(String[] args) {
        List<? extends Order> list1 = null;
        List<? super Order> list2 = null;
        List<Order> list3 = null;
        List<SubOrder> list4 = null;
        List<Object> list5 = null;

    /*
      ? extends A:
        G<? extends A>可以作为G<A> 和G<B>的父类，其中B是A的子类
      ? super A:
        G<? super A>可以作为G<A> 和<B>的父类，其中B是A的父类
     */

        list1 = list3;
        list1 = list4;
//        list1 = list5;


        list2 = list3;
//        list2 = list4;
        list2 = list5;


        //写入数据:
        //编译不通过
//        list1. add(new SubOrder());
        //编译通过
        list2. add(new Order());
        list2. add(new SubOrder());


    }
}
