package ReflectionPractice.ReflectionCodes.RuntimeClass.Get;

import ReflectionPractice.ReflectionCodes.Util.Employee;

import java.lang.reflect.Constructor;

public class ConstructTest {
    //获取类构造器结构
    public static void main(String[] args) {
        Class c = Employee.class;
        //getConstructors():获取当前运行时类中声明为public的构造器
        Constructor[] constructors = c.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("****************");
        //getDeclaredConstructors(): 获取当前运行时类中声明的所有的构造器
        Constructor[] dconstructors = c.getDeclaredConstructors();
        for (Constructor constructor : dconstructors) {
            System.out.println(constructor);
        }
    }
}
