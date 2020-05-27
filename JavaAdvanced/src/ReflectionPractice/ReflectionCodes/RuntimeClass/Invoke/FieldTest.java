package ReflectionPractice.ReflectionCodes.RuntimeClass.Invoke;

import ReflectionPractice.ReflectionCodes.Util.Employee;

import java.lang.reflect.Field;

public class FieldTest {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        Class<Employee> employeeClass = Employee.class;
        //通过反射获取类实例对象
        Employee employee = employeeClass.newInstance();

        //获取指定的属性:要求运行时类中属性声明为public(通常不采用此方法)
        Field name = employeeClass.getField("name");
        //设置当前属性的值
        //set():参数1:指明设置哪个对象的属性 参数2:将此属性值设置为多少
        name.set(employee,"tom");
        //获取当前属性的值
        //get():参数1:获取哪个对象的当前属性值
        System.out.println(name.get(employee));
        System.out.println(employee);


        //如何操作运行时类中的指定的属性
        //1.getDeclaredField(String fieLdName):获取运行时类中指定变量名的属性
        Field name1 = employeeClass.getDeclaredField( "name");
        //2.保证当前属性是可访问的
        name1.setAccessible(true) ;
        //3.获取、设置指定对象的此属性值
        name.set(employee, "jerry");
        System.out.println(name.get(employee));


    }
}
