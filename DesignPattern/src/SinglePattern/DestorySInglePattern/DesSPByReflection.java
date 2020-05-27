package SinglePattern.DestorySInglePattern;

import SinglePattern.getInstance.SinglePatternehan;
import SinglePattern.getInstance.SinglePatternlan;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author whb
 * @date 2020/5/27-12:28
 * @
 */
public class DesSPByReflection {
    //通过发射的方式即可获取到一个新的单例对象，这就破坏了单例。
    public static void main(String[] args) {
        testEhan();
        testLanhan();
    }
    public static void testEhan(){
        Class c = SinglePatternehan.class;
        try {
            Constructor declaredConstructor = c.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            Object instance = declaredConstructor.newInstance();
            SinglePatternehan instance1 = SinglePatternehan.getInstance();
            System.out.println(instance == instance1);//false
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    public static void testLanhan(){
        Class c = SinglePatternlan.class;
        try {
            Constructor declaredConstructor = c.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            Object instance = declaredConstructor.newInstance();
            SinglePatternlan instance1 = SinglePatternlan.getInstance();
            System.out.println(instance == instance1);//false
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
