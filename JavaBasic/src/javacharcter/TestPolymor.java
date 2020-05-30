package javacharcter;

public class TestPolymor {
    public static void main(String[] args) {
        //Animalp animal = new Animalp("anim",12);
        AbstractAnimalp dog1 = new Dogp("hi",1,"b");
        AbstractAnimalp cat1 = new Catp("hu",2,"r");
        //animal.enjoy();
        dog1.enjoy();
        cat1.enjoy();
    }
}
/*
class Animalp{
    String name;
    int age;
    Animalp(String name,int age){
        this.name = name;
        this.age = age;
    }
    public void enjoy(){
        System.out.println("animals");
    }
}
 */
abstract class AbstractAnimalp {
    String name;
    int age;

    AbstractAnimalp(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void enjoy();
}
class Dogp extends AbstractAnimalp{

    String toothcolor;

    Dogp(String name,int age,String toothcolor){
        super(name,age);
        this.toothcolor = toothcolor;
    }

    @Override
    public void enjoy() {
        System.out.println("dog");;
    }
}
class Catp extends AbstractAnimalp{

    String nosecolor;

    Catp(String name,int age,String nosecolor){
        super(name,age);
        this.nosecolor = nosecolor;
    }
    @Override
    public void enjoy() {
        System.out.println("cat");;
    }
}
