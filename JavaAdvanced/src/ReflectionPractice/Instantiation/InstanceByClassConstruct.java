package ReflectionPractice.Instantiation;

import ReflectionPractice.ReflectionCodes.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class InstanceByClassConstruct {
    public static void main(String[] args) {
        Class c = Student.class;
        Constructor<Student> constructor = null;
        try {
            constructor = c.getDeclaredConstructor(String.class,int.class);
            constructor.setAccessible(true);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            Student student = constructor.newInstance("jerry",22);
            System.out.println(student);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
