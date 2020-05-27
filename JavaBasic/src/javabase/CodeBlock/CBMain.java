package javabase.CodeBlock;

public class CBMain {
    /*
    Fat静态代码块
    Son静态代码块
    main()方法
    Fat非静态代码块
    Fat构造方法
    Son非静态代码块
    Son构造方法
     */
}
class Fat{
    static {
        System.out.println("Fat静态代码块");
    }
    {
        System.out.println("Fat非静态代码块");
    }
    Fat(){
        System.out.println("Fat构造方法");
    }

}
class Son extends Fat{
    static {
        System.out.println("Son静态代码块");
    }
    {
        System.out.println("Son非静态代码块");
    }
    Son(){
        System.out.println("Son构造方法");
    }

    public static void main(String[] args) {
        System.out.println("main()方法");
        new Son();
    }
}