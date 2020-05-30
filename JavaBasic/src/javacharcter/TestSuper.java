package javacharcter;

class Supclass{
    private int n;
    Supclass(){
        System.out.println("Superclass");
    }
    Supclass(int n){
        System.out.println(n);
    }
    @Override
    public String toString(){
        return "";
    }
}
class Subclass extends Supclass{
    private int n=0;
    Subclass(){
        //super();
        System.out.println("Subclass");
    }
    Subclass(int n){
        super(30);
        System.out.println(n);
    }

}
public class TestSuper {
    public static void main(String [] args){
        Subclass sc = new Subclass();
        Subclass sc2 = new Subclass(300);
    }

}
