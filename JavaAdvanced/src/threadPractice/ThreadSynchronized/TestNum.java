package threadPractice.ThreadSynchronized;

public class TestNum implements Runnable{
    int a = 10;
    public synchronized void m1(){
        a=1000;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("a = "+a);
    }
    public synchronized void m2(){
        a=2000;
        System.out.println("m2  "+a);
    }
    @Override
    public void run() {
        m1();
    }

    public static void main(String[] args) {
        TestNum tn = new TestNum();
        Thread t = new Thread(tn);
        t.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tn.m2();
        System.out.println("main  "+tn.a);
    }
}
