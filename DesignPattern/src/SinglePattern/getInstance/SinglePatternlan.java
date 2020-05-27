package SinglePattern.getInstance;

import java.io.Serializable;

/**
 * @author whb
 * @date 2020/5/27-20:32
 * @
 */
public class SinglePatternlan implements Serializable {

    static final long SerserialVersionUID = 78465468616571545L;
    static SinglePatternlan sp;
    static int count = 0;

    //如果不考虑反射情况下，构造器中代码为空，但若为空，可能会在类外通过反射生成新对象，反而不是单例模式
    private SinglePatternlan() {
        if (sp != null){
            throw new RuntimeException("Private Constructor external called...");
        }
    }
    //序列化时同样返回同一个单例对象
    private Object readResolve() {
        return getInstance();
    }
    //懒汉式单例模式可能在同步时出现异常，不能做到真正的单例
    public static synchronized SinglePatternlan getInstance() {
        if (sp == null) {
            count++;
            sp = new SinglePatternlan();
            return sp;
        } else {
            return sp;
        }
    }

    public void show() {
        System.out.println(this);
        System.out.println("懒汉模式类实例化对象个数" + count);
    }
}
