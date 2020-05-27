package ReflectionPractice.ClassLoader;

public class ClassLoaderSource {
    /*
    JDK中的ClassLoader如何实现？


    protected synchronized Class<?> loadClass(String name, boolean resolve)
    throws ClassNotFoundException
    {
    // First, check if the class has already been loaded
    Class c = findLoadedClass(name);
    if (c == null) {
        try {
        if (parent != null) {
            c = parent.loadClass(name, false);
        } else {
            c = findBootstrapClass0(name);
        }
        } catch (ClassNotFoundException e) {
            // If still not found, then invoke findClass in order
            // to find the class.
            c = findClass(name);
        }
    }
    if (resolve) {
        resolveClass(c);
    }
    return c;
    }


    方法原理：
    1、第5行，首先查找.class是否被加载过
    2、第6行~第12行，如果.class文件没有被加载过，那么会去找加载器的父加载器。
        如果父加载器不是null（不是Bootstrap ClassLoader），那么就执行父加载器的loadClass方法，把类加载请求一直向上抛，
        直到父加载器为null（是Bootstrap ClassLoader）为止
    3、第13行~第17行，父加载器开始尝试加载.class文件，加载成功就返回一个java.lang.Class，
        加载不成功就抛出一个ClassNotFoundException，给子加载器去加载
    4、第19行~第21行，如果要解析这个.class文件的话，就解析一下，解析的作用类加载的文章里面也写了，
        主要就是将符号引用替换为直接引用的过程
    我们看一下findClass这个方法：
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        throw new ClassNotFoundException(name);
    }
    没有具体实现，只抛了一个异常，而且是protected的，这充分证明了：这个方法就是给开发者重写用的。



    */



    /*
    Class的getResourceAsStrea(String name)的源代码:

    public InputStream getResourceAsStream(String name) {
        name = resolveName(name);
        ClassLoader cl = getClassLoader0();
        if (cl==null) {
            // A system class.
            return ClassLoader.getSystemResourceAsStream(name);
        }
        return cl.getResourceAsStream(name);
    }

    private String resolveName(String name) {
        if (name == null) {
            return name;
        }
        if (!name.startsWith("/")) {
            Class c = this;
            while (c.isArray()) {
                c = c.getComponentType();
            }
            String baseName = c.getName();
            int index = baseName.lastIndexOf('.');
            if (index != -1) {
                name = baseName.substring(0, index).replace('.', '/')
                    +"/"+name;
            }
        } else {
            name = name.substring(1);
        }
        return name;
    }
    */
}
