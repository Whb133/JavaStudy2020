package javacharcter.Interface.JDk8InterfaceNewCharacter;

public class Animal {

    public void eat() {
        System.out.println("Animal eating");
    }

    public void sleep() {
        System.out.println("Animal sleeping");
    }
}

class Bird extends Animal implements Flyable,Living{


    static Bird bird = new Bird();
    private Bird(){

    }
    public static Bird getBirdInstance(){
        return bird;
    }

    @Override
    public void DoSomething() {
        System.out.println("I can dance in sky!");
    }

    @Override
    public void live() {
        eat();
        sleep();
//        Flyable.super.fly();
        fly();
        DoSomething();
        Flyable.landing();
    }

    @Override
    public void test1() {
        System.out.println("同名的抽象方法，必须重写，但不必纠结到底调用哪一个接口");
    }

    @Override
    public void test2() {
        System.out.println("必须重写不同接口中同名同参数的默认方法");
    }


    @Override
    public void eat() {
        System.out.println("Bird eating");
    }

    @Override
    public void sleep() {
        System.out.println("Bird sleeping");
    }
}


