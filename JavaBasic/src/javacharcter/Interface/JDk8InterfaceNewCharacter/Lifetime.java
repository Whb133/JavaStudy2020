package javacharcter.Interface.JDk8InterfaceNewCharacter;

public class Lifetime implements Runnable{

    Living living;

    Lifetime(Living living){
        this.living = living;
    }
    @Override
    public void run() {
        living.birth();
        living.live();
        Living.die();
    }
}
