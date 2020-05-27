package ReflectionPractice.ReflectionCodes.RuntimeClass.Invoke;

import ReflectionPractice.ReflectionCodes.Util.Employee;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //如何调用运行时类中的指定的构造器
        Class<Employee> employeeClass = Employee.class;
        /*
        1.获取指定的构造器
        getDeclaredConstructor():参数:指明构造器的参数列表
        */
        Constructor<Employee> dConstructor = employeeClass.getDeclaredConstructor(String.class, int.class);
        //2.保证此构造器是可访问的
        dConstructor.setAccessible(true);
        //3.调用此构造器创建运行时类的对象
        Employee toom = dConstructor.newInstance("toom",23);
        System.out.println(toom);
    }
}
