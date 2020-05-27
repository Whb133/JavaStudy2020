package ReflectionPractice.ReflectionCodes.RuntimeClass.Get;

import ReflectionPractice.ReflectionCodes.Util.Employee;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MethodTest {
    public static void main(String[] args) {
        Class c = Employee.class;
        //getMethods():获取当前运行时类及其所有父类中声明为public权限的方法
        Method[] methods = c.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("*********************");
        //getDeclaredMethods():获取当前运行时类中声明的所有方法。(不包含父类中声明的方法)
        Method[] dmethods = c.getDeclaredMethods();
        for (Method method : dmethods) {
            System.out.println(method);
        }


        /*
        @Xxxx
        权限修饰符返回值类型方法名( 参数类型1形参名1,...) throws XxxException{}
        */
        for (Method method : dmethods) {
            System.out.println(method);
            //获取注解
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }
            //获取权限修饰符
            System.out.print(Modifier.toString(method.getModifiers()) + "\t");
            //获取返回值类型
            System.out.print(method.getReturnType() + "\t");
            //获取方法名
            System.out.print(method.getName());
            System.out.print("(");

            //获取参数列表
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (!(parameterTypes == null && parameterTypes.length == 0)) {
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (i == parameterTypes.length - 1) {
                        System.out.print(parameterTypes[i].getName() + "  args_" + i);
                        break;
                    }
                    System.out.print(parameterTypes[i].getName() + "  args_" + i + ",");
                }
            }
            System.out.print(")");

            Class<?>[] exceptionTypes = method.getExceptionTypes();
            if (exceptionTypes.length > 0) {
                System.out.print("throws ");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if (i == exceptionTypes.length - 1) {
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.print(exceptionTypes[i].getName() + ",");
                }


            }
            System.out.println();
        }
    }
}
