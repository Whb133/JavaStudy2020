package SinglePattern.getInstance;

import java.io.Serializable;

/**
 * @author whb
 * @date 2020/5/27-20:31
 * @
 */
public class SinglePatternehan implements Serializable {

    static final long SerserialVersionUID = 5791763173435435L;
    static int count = 1;
    static SinglePatternehan sp = new SinglePatternehan();
    //如果不考虑反射情况下，构造器中代码为空，但若为空，可能会在类外通过反射生成新对象，反而不是单例模式
    private SinglePatternehan(){
        if (sp != null){
            throw new RuntimeException("Private Constructor external called...");
        }
    }
    //序列化时同样返回同一个单例对象
    private Object readResolve() {
        return getInstance();
    }
    public static SinglePatternehan getInstance(){
        return sp;
    }
    public void show(){
        System.out.println(this);
        System.out.println("饿汉模式类实例化对象个数"+count);
    }
}
