package ReflectionPractice.ClassLoader;

import java.net.URL;

public class ClassLoaderTest {
    public static void main(String[] args) {

        //获取本类使用的加载器，对于自定义类，使用系统加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        //调用系统加载器的getParent()获取其父类，系统加载器其父类为扩展加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);
        //调用扩展加载器的getParent()获取其父类，扩展加载器其父类为根加载器（引导类加载器bootstrap）
        //引导类加载器主要负责加载java的核心类库， 无法加载自定义类的。
        ClassLoader classLoader2 = classLoader1.getParent();
        //结果为null，并不是没有，而是无法获取。
        System.out.println(classLoader2);

        ClassLoader classLoader3 = String.class.getClassLoader();
        System.out.println(classLoader3);

        System.out.println("******************************");
        //获得根类加载器所加载的核心类库,并会看到本机安装的Java环境变量指定的jdk中提供的核心jar包路径：
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for(URL url : urls){
            System.out.println(url.toExternalForm());
        }
    }
}
