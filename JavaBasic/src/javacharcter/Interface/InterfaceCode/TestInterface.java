package javacharcter.Interface.InterfaceCode;
interface Singer {
    public static final int a = 3;//redundant  多余的  static  final
    public abstract void sing();
    void eat();
//    double enjoy();
}
interface Painter{
    void paint();
    void sleep();
//    void enjoy();
}
class Studt implements Singer,Painter{

    String name;
    Studt(String name){
        this.name = name;
    }
    @Override
    public void sing(){
        System.out.println("singing");
    }
    @Override
    public void eat(){
        System.out.println("eating");
    }

    @Override
    public void paint() {
        System.out.println("painting");
    }

    @Override
    public void sleep() {
        System.out.println("sleeping");
    }
//    public void enjoy(){
//        System.out.println("enjoying");
//        return 1.0;
//    }
}
public class TestInterface{
    public static void main(String[] args) {
        Singer s1 = new Studt("lo");
        s1.sing();
        s1.eat();
        //s1.enjoy();
        Painter s2 = (Painter)s1;
        s2.paint();
        s2.sleep();
        //s2.enjoy();
    }
}
