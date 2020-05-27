package ReflectionPractice.ReflectionCodes.RuntimeClass.Get;

import ReflectionPractice.ReflectionCodes.Util.Employee;

import java.lang.annotation.Annotation;

public class AnnotationTest {
    public static void main(String[] args) {
        Class c = Employee.class;
        //获取运行时类的注解
        Annotation[] annotations = c.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}
