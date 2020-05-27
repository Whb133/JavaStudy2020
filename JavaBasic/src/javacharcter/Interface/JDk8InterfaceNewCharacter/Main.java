package javacharcter.Interface.JDk8InterfaceNewCharacter;

public class Main {
    public static void main(String[] args) {

        Thread bird = new Thread(new Lifetime(Bird.getBirdInstance()));
        bird.start();
        try {
            bird.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println("c开始执行");
        new Thread(new Lifetime(new Chrysanthemum())).start();
    }
}
