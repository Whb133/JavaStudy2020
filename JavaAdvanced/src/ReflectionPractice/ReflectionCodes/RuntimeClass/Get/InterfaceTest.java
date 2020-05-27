package ReflectionPractice.ReflectionCodes.RuntimeClass.Get;

import ReflectionPractice.ReflectionCodes.Util.Employee;

public class InterfaceTest {
    public static void main(String[] args) {
        Class c = Employee.class;

        //获取类实现的接口
        Class[] interfaces = c.getInterfaces();
        for (Class C : interfaces) {
            System.out.println(C);
        }
        System.out.println();
        //获取运行时类的父类实现的接口
        Class[] interfaces1 = c.getSuperclass().getInterfaces();
        for (Class C : interfaces1) {
            System.out.println(c);
        }
    }
}
