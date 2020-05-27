package genericPractice.GenericCodes;

import javax.jws.Oneway;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class GenericTest {

    public static void main(String[] args) {


        /*
        * 虽然类A是类B的父类，但是G<A> 和 G<B>二者不具备子父类关系，二者是并列关系。
        补充:类是类B的父类，A<G> 是B<G>的父类.
        * */
        //String 是Object的子类，多态性
        Object o = null;
        String s = null;
        o = s;

        Object[] objects = null;
        String[] strings = null;
        objects = strings;

        //List<Object>  和  List<String> 两个类并没有继承关系，只是并列关系，所以不能赋值。
        List<Object> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
//        list1 = list2;  //编译不通过
        /*反证法:
        假设 list1 = list2;
        list1. add(123);导致混入非String的数据,出错。
        */

        AbstractList<String> list4 = null ;
        List<String> list5 = null;
        ArrayList<String> list6 = null;
        list4 = list6;
        list5 = list6;



        /*
        通配符的使用。通配符 ？
        类A是类B的父类，G<A>和G<B>是没有关系的，二者共同的父类是: G<?>
        */
        List<Object> lis1 = null;
        List<String> lis2 = null;
        List<?> lit = null ;
        lit = lis1;
        lit = lis2;

        List<String> lst3 = new ArrayList<>();
        lst3. add("AA");
        lst3. add("BB");
        lst3. add("CC");
        lit = lst3;
        //添加:对于List<?>就不能向其内部添加数据。除了添加null外
//        lit.add("DD");
//        lit.add('?');
        lit.add(null);

        //获取(读取):允许读取数据，读取的数据类型为bject 。

        Object o1 = lit.get(0);
        System.out.println(o1);
        show(lis1);
        show1(lis1);
        show(lis2);
        show1(lis2);


    }
    public static <E> E show(List<E> list){
        return null;
    }

    public static void show1(List<?> list){

    }
}
