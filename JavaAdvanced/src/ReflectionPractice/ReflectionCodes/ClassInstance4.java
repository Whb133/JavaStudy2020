package ReflectionPractice.ReflectionCodes;

public class ClassInstance4 {
    //获取Class对象的四种方式
    public static void main(String[] args) {
        Class c1 = getClassInstance1();
        Class c2 = getClassInstance2();
        Class c3 = getClassInstance3();
        Class c4 = getClassInstance4();
        System.out.println(c1 == c2);
        System.out.println(c1 == c3);
        System.out.println(c1 == c4);
    }
    static Class getClassInstance1(){
        Class<Student> clazz = Student.class;
        return clazz;
    }
    static Class getClassInstance2(){
        Student s = new Student("tom");
        Class c =s.getClass();
        return c;
    }
    static Class getClassInstance3(){
        Class c = null;
        try {
            c = Class.forName("ReflectionPractice.ReflectionCodes.Student");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return c;
    }
    static Class getClassInstance4(){
        ClassLoader classLoader = Student.class.getClassLoader();
        Class c = null;
        try {
            c = classLoader.loadClass("ReflectionPractice.ReflectionCodes.Student");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return c;
    }
}
