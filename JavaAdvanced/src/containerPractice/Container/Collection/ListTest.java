package containerPractice.Container.Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author whb
 * @date 2020/5/29-16:40
 * @
 */
public class ListTest {
    public static void main(String[] args) {
        //Arrays.asList()生成的List是只允许读容器，不可对之元素进行修改
        // 异常java.lang.UnsupportedOperationException
        List<Integer> arrs = Arrays.asList(2,5,8,8,9,14,25);
        ArrayList<Integer> intarrs = new ArrayList<>();
        intarrs.addAll(arrs);
//        System.out.println("testRemove1");
//        testRemove1(intarrs);
//        System.out.println("testRemove2");
//        testRemove2(intarrs);
        System.out.println("testRemove3");
        testRemove3(intarrs);
    }

    public static void testRemove1(List<Integer> intarrs){
        //ArrayList中删除某元素，使用iterator
        Iterator<Integer> iterator = intarrs.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next == 8) {
                iterator.remove();
            }
        }
        System.out.println(intarrs);
    }

    public static void testRemove2(List<Integer> intarrs){
        //ArrayList中删除某元素，使用fori循环(从后往前，因为正序的话，List会自己移动元素位置)
        intarrs.add(8);
        for (int i = intarrs.size()-1; i > 0; i--) {
            if (intarrs.get(i) == 8) {
                intarrs.remove(i);
            }
        }
        System.out.println("正确代码，从后往前i--");
        System.out.println(intarrs);


        //ArrayList中删除某元素,正序删除出错，可能会漏掉个别元素
        intarrs.add(8);
        for (int i = 0; i < intarrs.size()-1; i++) {
            if (intarrs.get(i) == 8) {
                intarrs.remove(i);
            }
        }
        System.out.println("错误代码，从前往后i++");
        System.out.println(intarrs);
    }

    public static void testRemove3(List<Integer> intarrs){
        //删除元素后继续循环会报错误信息ConcurrentModificationException，
        //因为元素在使用的时候发生了并发的修改，导致异常抛出。
        //但是删除完毕马上使用break跳出，则不会触发报错。但会出现如果删除两个相同元素，只能删除一个后退出
        for (Integer arr : intarrs) {
            if (arr == 8){
                intarrs.remove(arr);
                break;
            }
        }
        System.out.println(intarrs);
    }
}
