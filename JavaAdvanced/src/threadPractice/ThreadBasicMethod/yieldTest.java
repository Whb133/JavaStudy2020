package threadPractice.ThreadBasicMethod;

public class yieldTest {
    public static void main(String[] args){

//        Thread t1 = new Thread(new yieldRunner1("t1"));
//        Thread t2 = new Thread(new yieldRunner1("t2"));
//        t1.start();
//        t2.start();

        YieldRunner2 t1 = new YieldRunner2("t1");
        YieldRunner2 t2 = new YieldRunner2("t2");
        t1.start();
        t2.start();
    }
}
class YieldRunner1 implements Runnable{

    String name;
    YieldRunner1(String name){
        this.name = name;
    }
    public void run(){
        for (int i = 0;i<500;i++){
            System.out.println(this.name+" : "+i);
            if (i % 50 == 0){
                Thread.yield();
            }

        }
    }
}
class YieldRunner2 extends Thread{

    YieldRunner2(String name){
        super(name);
    }
    @Override
    public void run() {
        for (int i = 1;i<=500;i++){
            System.out.println(getName()+" : "+i);
            if (i % 50 == 0){
                System.out.println("********");
                yield();
            }
        }
    }
}