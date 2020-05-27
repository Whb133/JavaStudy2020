package ProxyPattern.ProxyCodes.DynamicProxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public interface ChipManufacture {
    String mannufacture(String model);
    void RD();
}
//被代理类
class SumSang implements ChipManufacture{

    @Override
    public String mannufacture(String model) {
        return model;
    }

    @Override
    public void RD() {
        System.out.println("研发中！");
    }
}
//代理类
class DynamicProxy{

    //此方法的参数为被代理类对象
    static Object getProxyInstance(Object obj){
        MyInvocationHandler handle = new MyInvocationHandler();
        //此时该代理类代理的是  obj类
        handle.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handle);

    }
}

class MyInvocationHandler implements InvocationHandler {

    //被代理类，由于是动态代理，不知道具体所要代理的类型，表示为Object
    private Object obj;

    //将被代理类对象和代理类绑定
    void bind(Object obj){
        this.obj = obj;
    }

    //当我们通过代理类的对象，调用方法a时，就会自动的调用如下的方法: invoke()
    //将被代理类要执行的方法a的功能就声明在invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //method:即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
        //obj:被代理类的对象
        Object returnValue = method.invoke(obj, args);
        return returnValue;
    }
}
class DMain{
    public static void main(String[] args) {

        //proxyInstance：代理类对象
        ChipManufacture proxyInstance = (ChipManufacture) DynamicProxy.getProxyInstance(new SumSang());
        String ss = proxyInstance.mannufacture("ss");
        System.out.println(ss);
        proxyInstance.RD();

    }
}
