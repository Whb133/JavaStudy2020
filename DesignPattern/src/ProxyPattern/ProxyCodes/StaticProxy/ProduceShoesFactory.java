package ProxyPattern.ProxyCodes.StaticProxy;

public interface ProduceShoesFactory {
    void produceShoes();
}
//代理类
class ProxyProduceFactory implements ProduceShoesFactory{

    public ProduceShoesFactory factory;
    public ProxyProduceFactory(ProduceShoesFactory factory){
        this.factory = factory;
    }
    @Override
    public void produceShoes() {
        System.out.println("代理之前操作！");
        factory.produceShoes();
        System.out.println("代理之后操作！");
    }
}

//被代理类
class NikeShoes implements ProduceShoesFactory{

    @Override
    public void produceShoes() {
        System.out.println("生产nike鞋子！");
    }
}
class Main{
    public static void main(String[] args) {
        /*
        静态代理举例
        特点:代理类和被代理类在编译期间，就确定下来了。
        */
        //被代理类对象
        NikeShoes nikeShoes = new NikeShoes();
        //代理类对象
        ProxyProduceFactory proxyProduceFactory = new ProxyProduceFactory(nikeShoes);

        proxyProduceFactory.produceShoes();
    }
}
