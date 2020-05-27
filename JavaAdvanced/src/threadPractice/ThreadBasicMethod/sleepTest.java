package threadPractice.ThreadBasicMethod;

import java.util.Date;

public class sleepTest {
    public static void main(String[] args) {

//        sleepRunner1 runner1 = new sleepRunner1();
//        runner1.start();


        sleepRunner2 runner2 = new sleepRunner2();
        Thread t = new Thread(runner2);
        t.start();

        try{
            Thread.sleep(10000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        t.interrupt();

//        for (int i =0;i<200;i++){
//            System.out.println("Main running"+i);
//        }
    }
}
class sleepRunner1 extends Thread{
    @Override
    public void run() {
        for (int i =0;i<200;i++){
            System.out.println("Runner1 running"+i);
            try {
                Thread.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
class sleepRunner2 implements Runnable{

    private boolean flag = true;
    public void run(){
        while (flag){
            System.out.println("Runner2 running"+new Date());
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                shutdown();
            }
        }
    }
    public void shutdown(){
        this.flag =  false;
    }
}