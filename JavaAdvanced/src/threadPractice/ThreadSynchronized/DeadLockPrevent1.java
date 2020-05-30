package threadPractice.ThreadSynchronized;

public class DeadLockPrevent1 implements Runnable {

    int flag = 1;
    static Object o1 = new Object();
    static Object o2 = new Object();

    @Override
    public void run(){
        if (flag == 1){
            synchronized (o1){
                System.out.println("flag1   o1");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2){
                    System.out.println("flag1   o2");
                }
            }
        }
//        if (flag == 2){
//            synchronized (o2){
//                System.out.println("flag2   o2");
//                synchronized (o1){
//                    System.out.println("flag2   o1");
//                }
//            }
//        }
        if (flag == 2){
            synchronized (o1){
                System.out.println("flag2   o1");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2){
                    System.out.println("flag2   o2");
                }
            }
        }
    }
    public static void main(String[] args){
        DeadLockPrevent1 d1 = new DeadLockPrevent1();
        DeadLockPrevent1 d2 = new DeadLockPrevent1();
        d1.flag = 1;
        d2.flag = 2;
        Thread t1 = new Thread(d1);
        Thread t2 = new Thread(d2);
        t1.start();
        t2.start();
    }
}
