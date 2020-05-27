package SinglePattern.DestorySInglePattern;

import SinglePattern.getInstance.SinglePatternehan;
import SinglePattern.getInstance.SinglePatternlan;

import java.io.*;

/**
 * @author whb
 * @date 2020/5/27-12:30
 * @
 */
public class DesSPBySerializable implements Serializable {
    /*
    通过先序列化再反序列化的方式，可获取到一个新的单例对象，这就破坏了单例。
    因为在对象反序列化的过程中，序列化会通过反射调用无参数的构造方法创建一个新的对象，所以，通过反序列化也能破坏单例。
    * */
    public static void main(String[] args) throws Exception {
        testEHan();
        testLanHan();
    }
    public static void testEHan() throws Exception{
        SinglePatternehan instance = SinglePatternehan.getInstance();
        String path = "E:\\JavaCode\\JavaStudy2020\\DesignPattern\\src\\SinglePattern\\getInstance\\SerilizationObject.txt";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        oos.writeObject(instance);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        SinglePatternehan o = (SinglePatternehan)ois.readObject();
        System.out.println(o == instance);
    }
    public static void testLanHan() throws Exception{
        SinglePatternlan instance = SinglePatternlan.getInstance();
        String path = "E:\\JavaCode\\JavaStudy2020\\DesignPattern\\src\\SinglePattern\\getInstance\\SerilizationObject.txt";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        oos.writeObject(instance);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        SinglePatternlan o = (SinglePatternlan) ois.readObject();
        System.out.println(o == instance);
    }
}
