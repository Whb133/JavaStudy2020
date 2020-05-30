package threadPractice.ThreadBasicMethod;

public class joinTest {
    public static void main(String[] args){
        joinRunner1 runner2 = new joinRunner1();
        Thread t = new Thread(runner2);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i =0;i<50;i++){
            System.out.println("MainRunner"+i);
        }
    }
}
class joinRunner1 implements Runnable{
    @Override
    public void run(){
        for (int i =0;i<50;i++){
            System.out.println("joinRunner"+i);
        }
    }
}