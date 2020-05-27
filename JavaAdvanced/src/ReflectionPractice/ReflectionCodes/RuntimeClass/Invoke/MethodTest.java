package ReflectionPractice.ReflectionCodes.RuntimeClass.Invoke;

import ReflectionPractice.ClassLoader.MyClassLoader.Person;
import ReflectionPractice.ReflectionCodes.Util.Employee;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodTest {
    //如何操作运行时类中的指定的方法
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //创建运行时类的对象
        Class<Employee> employeeClass = Employee.class;
        Employee employee = employeeClass.newInstance();

        /*
        1.获取指定的某个方法
        getDeclaredMethod():参数1 :指明获取的方法的名称  参数2: 指明获取的方法的形参列表
        */
        Method setName = employeeClass.getMethod("setName", String.class);
        Method show = employeeClass.getDeclaredMethod("show", String.class);

        /*
        2.保证当前方法是可访问的
        */
        show.setAccessible(true);

        /*
        3.invoke():参数1:方法的调用者   参数2: 给方法形参赋值的实参
        invoke()的返回值即为对应类中调用的方法的返回值。
        */
        setName.invoke(employee,"tiim");//employee.setName("tiim");
        //如果调用的运行时类中的方法没有返回值，则此invoke()返回null
        Object returnValue = show.invoke(employee, "hello");//employee.show("hello");
        System.out.println(returnValue);
        System.out.println(employee);


        //******如何调用静态方法******
        //静态方法  在原对象参数位置变更为类对象（Class对象）或为null
        Method eat = employeeClass.getDeclaredMethod("eat", String.class);
        eat.invoke(null,"apple");
        eat.invoke(Employee.class,"pear");
        //报错：java.lang.IllegalArgumentException: wrong number of arguments
        //eat.invoke(Employee.class,null);

        Method sleep = employeeClass.getDeclaredMethod("sleep");
        sleep.invoke(null,null);
        sleep.invoke(Employee.class);
        sleep.invoke(Employee.class,null);

    }
}
