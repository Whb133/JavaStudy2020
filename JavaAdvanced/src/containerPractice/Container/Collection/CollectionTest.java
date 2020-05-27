package containerPractice.Container.Collection;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class CollectionTest {
    public static void main(String[] args) {


        //Collection中可使用泛型指定所要装的数据类型.
        Collection<Integer> arr1 = new ArrayList<>();
        arr1.add(1);//自动装箱
//        arrs.add("sda");


        //若不指定，则可装任何类型的数据。
        Collection arr2 = new ArrayList<>();

        //add(object e): 将元素e添加到集合coll中
        arr2.add(1);
        arr2.add("sda");
        arr2.add(Instant.now());
        arr2.add(LocalDateTime.now());



        //size():获取添加的元素的个数
        int size = arr2.size();
        System.out.println(size);

        //addALl(Collection coll1): 将coll1集合中的元素添加到当前的集合中
        Collection arr3 = new ArrayList();
        arr3.add("hello");
        arr3.add(new Date());
        arr2.addAll(arr3);
        System.out.println(arr2);

        //clear():清空集合元素,只是将集合中的元素清除，依然保留该对象
        arr2.clear();
        //isEmpty():判断当前集合是否为空
        System.out.println(arr2.isEmpty());


//        Iterator iterator= arr2.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }


    }
}
