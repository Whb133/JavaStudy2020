package javacharcter.Interface.JDk8InterfaceNewCharacter;

class InterfaceText{
    /*
    接口不能有构造器
    接口中定义只能是常量，不能是变量，public static final
    接口中可以有抽象方法，public abstract
    jdk1.8接口新特性：
    1.接口中可以存在有方法体的方法，即默认方法（default）和静态方法（static）。
    2.在接口中定义的静态方法（--static）只能由接口调用。
    3.在接口中定义的默认方法（--defaul）可以由接口的实现类的对象来调用。
        如果没有实现类对象，默认方法可以直接通过接口名.super.方法名  调用。
        如果实现类重写了接口中的默认方法，则调用的依然是重写以后的方法。
    4.如果子类（或实现类）继承的父类和实现的接口有同名同参数列表的默认方法，
        在子类没有重写该方法时，调用该方法时调用的是父类的方法。
    5.如果实现类实现了多个不同类型的接口，且这些接口中有同名同参数列表的默认方法，
        若实现类没有重现该方法，报错。
     */
}
interface Flyable {

    public static final String FlyUtil = "wings";

    public default void fly(){
        System.out.println("Year I can fly!");
    }

    void DoSomething();

    public static void landing(){
        System.out.println("Landing safely！");
    }

    //测试方法
    void test1();
    default void test2(){

    }
}
interface Living{

    public static final String Air = "oxygen";

    public default void birth(){
        System.out.println("Hello World!");
    }

    void live();

    public static void die(){
        System.out.println("Goodbye My Life!");
    }

    //测试方法
    void test1();
    default void test2(){

    }
}
