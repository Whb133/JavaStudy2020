package ReflectionPractice.ClassLoader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadResouce {
    public static void main(String[] args) {
//        loading();
        loading2();
    }

    //使用文件流加载配置文件
    static void loading(){
        Properties properties  = new Properties();
        FileInputStream fis = null;
        FileInputStream fis1 = null;
        try {
            fis = new FileInputStream("jdbc.properties");
            fis1 = new FileInputStream("jdbc1.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            //此时的jdbc必须位于整个project下
            //可有效加载多个输入流
            properties.load(fis1);
            properties.load(fis);
            System.out.println(properties.getProperty("name"));
            System.out.println(properties.getProperty("name1"));
            System.out.println(properties.getProperty("password"));
            System.out.println(properties.getProperty("password1"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //使用CLassLoader加载配置文件
    static void loading2(){
        Properties properties = new Properties();
        ClassLoader classLoader = LoadResouce.class.getClassLoader();
        //此时的jdbc必须位于本module的src中
        InputStream is = classLoader.getResourceAsStream("jdbc.properties");
        try {
            properties.load(is);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(properties.getProperty("name"));
        System.out.println(properties.getProperty("password"));
    }
}
