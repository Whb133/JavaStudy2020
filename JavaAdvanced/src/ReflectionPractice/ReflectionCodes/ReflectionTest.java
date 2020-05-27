package ReflectionPractice.ReflectionCodes;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {
    //通过某类的Class对象反过来获取该类信息（反射）
    public static void main(String[] args) throws Exception{

        //得到学生类对象
        Class clazz = Student.class;
        publicMethodTest(clazz);
        System.out.println("***************************");
        praviteMethodTest(clazz);

    }

    static void publicMethodTest(Class clazz)throws Exception{
        //反射调用public构造器，属性，方法

        //获取类公有构造器，参数为各种参数 类对象
        Constructor constructor = clazz.getConstructor(String.class);
        //通过得到的类构造器创建类实例对象
        Student s = (Student) constructor.newInstance("tim");
        System.out.println(s);

        Field name = clazz.getField("name");
        //修改该对象的对应属性值
        name.set(s,"tim123");
        System.out.println(s);

        Method m = clazz.getMethod("showName");
        //使用反射得到的对象调用反射得到的方法
        m.invoke(s);
    }

    static void praviteMethodTest(Class clazz)throws Exception{
        //反射调用pravite构造器，属性，方法

        //反射调用私有构造器
        Constructor constructor = clazz.getDeclaredConstructor(String.class,int.class);
        constructor.setAccessible(true);
        Student s = (Student)constructor.newInstance("jack",20);
        System.out.println(s);

        //反射调用私有属性
        Field age = clazz.getDeclaredField("age");
        age.setAccessible(true);
        age.set(s,26);
        System.out.println(s);

        //反射调用私有方法
        Method m = clazz.getDeclaredMethod("show");
        m.setAccessible(true);
        m.invoke(s);
    }
}
