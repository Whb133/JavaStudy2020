package ReflectionPractice.ReflectionCodes.RuntimeClass.Get;

import ReflectionPractice.ClassLoader.MyClassLoader.Person;
import ReflectionPractice.ReflectionCodes.Util.Employee;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class SuperClassTest {
    public static void main(String[] args) {

        Class c = Employee.class;

        //获取其父类
        Class superclass = c.getSuperclass();
        System.out.println(superclass.getName());

        //获取其带泛型的父类
        Type genericSuperclass = c.getGenericSuperclass();
        System.out.println(genericSuperclass);

        //获取运行时类的带泛型的父类的泛型
        Type genericSuperclass1 = c.getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) genericSuperclass1;
        //获取泛型类型
        Type[] actualTypeArguments = paramType.getActualTypeArguments();
        System.out.println(actualTypeArguments[0].getTypeName());
        System.out.println(((Class)actualTypeArguments [0]).getName());



    }
}
