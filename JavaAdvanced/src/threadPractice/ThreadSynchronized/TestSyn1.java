package threadPractice.ThreadSynchronized;

public class TestSyn1 implements Runnable{

    Timer timer = new Timer();

    public static void main(String []args){
        TestSyn1 test = new TestSyn1();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        Thread t3 = new Thread(test);
        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");
        t1.start();
        t2.start();
        t3.start();
    }

    @Override
    public void run() {
        timer.add();
    }
}
class Timer{
    private static int num = 0;
    public synchronized void add(){
        num++;
        try{
            Thread.sleep(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"你是"+num);
    }
}