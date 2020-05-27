package ReflectionPractice.ReflectionCodes;


import java.util.Random;

public class ReflectionDynamic {
    public static void main(String[] args) {

        int i = new Random().nextInt(3);
        String classpath = "";
        switch (i){
            case 0:
                classpath = "ReflectionPractice.ClassLoader.MyClassLoader.Person";
                break;
            case 1:
                classpath = "java.lang.Object";
                break;
            case 2:
                classpath = "java.util.Date";
                break;
        }
        Object instance = null;
        try {
            instance = getInstance(classpath);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        System.out.println(instance);

    }
    static Object getInstance (String classpsth) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

            Class c = Class.forName(classpsth);
            return c.newInstance();

    }
}
