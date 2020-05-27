package ioPractice.ObjectIO;

import java.io.*;

public class ObjectTest {
    public static void main(String[] args) {
        T t = new T();
        try {
            FileOutputStream fos = new FileOutputStream("fileTest.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(t);

            FileInputStream fis = new FileInputStream("fileTest.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            T tReader = (T)ois.readObject();
            System.out.println(tReader.a+" "+tReader.b+" "+tReader.c+" "+tReader.flag);
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
class T implements Serializable {
    int a = 1;
    float b = 5.9f;
    double c = 7.0;
    transient int flag = 10;
}
