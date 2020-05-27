package ReflectionPractice.ReflectionCodes;

import java.lang.annotation.ElementType;

public class ClassObject {
    public static void main(String[] args) {

        //CLass实例可以是哪些结构的说明:

        Class c1 = Object. class;
        Class c2 = Comparable. class;
        Class c3 = String[].class;
        Class c4 = int[][]. class ;
        Class c5 = ElementType. class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void. class;
        Class c9 = Class.class;
        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        //只要元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);

    }
}
