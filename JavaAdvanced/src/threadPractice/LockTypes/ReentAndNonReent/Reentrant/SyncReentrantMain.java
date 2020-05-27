package threadPractice.LockTypes.ReentAndNonReent.Reentrant;

    /*
    可重入锁:可重复可递归调用的锁  synchronized
    一个类的A、B两个方法，A、B都有获得同一把锁，当A方法调用时，获得锁，
    在A方法的锁还没有被释放时，调用B方法时，B方法也获得该锁。
    这种情景，可以是不同的线程分别调用这个两个方法。也可是同一个线程，A方法中调用B方法，这个线程调用A方法。
    */

public class SyncReentrantMain {
    public static void main(String[] args) {

        SyncR1 syncR1 = new SyncR1();
        new Thread(syncR1).start();
        new Thread(syncR1).start();

        SyncR2 syncR2 = new SyncR2();
        new Thread(syncR2).start();
        new Thread(syncR2).start();
    }
}

    /*
    可重入锁举例一：
    不同的线程分别调用这个两个方法
     */
class SyncR1 implements Runnable{

    int num = 10;
    @Override
    public void run() {

        add();
        inc();
    }
    synchronized void add(){
        num++;
        System.out.println(Thread.currentThread().getName()+" add : "+num);
        inc();

    }
    synchronized void inc(){
        num--;
        System.out.println(Thread.currentThread().getName()+" inc : "+num);
    }
}
    /*
    可重入锁举例二：
    同一个线程，A方法中调用B方法，这个线程调用A方法。
     */
class SyncR2 implements Runnable{

    int num = 10;
    @Override
    public void run() {

        add();
    }
     synchronized void add(){
        num++;
        System.out.println(Thread.currentThread().getName()+" add : "+num);
        inc();

    }
    synchronized void inc(){
        num--;
        System.out.println(Thread.currentThread().getName()+" inc : "+num);
    }
}
