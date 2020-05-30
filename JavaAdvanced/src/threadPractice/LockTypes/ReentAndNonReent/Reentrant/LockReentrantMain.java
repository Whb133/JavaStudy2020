package threadPractice.LockTypes.ReentAndNonReent.Reentrant;

     /*
    可重入锁:可重复可递归调用的锁  synchronized
    一个类的A、B两个方法，A、B都有获得同一把锁，当A方法调用时，获得锁，
    在A方法的锁还没有被释放时，调用B方法时，B方法也获得该锁。
    这种情景，可以是不同的线程分别调用这个两个方法。也可是同一个线程，A方法中调用B方法，这个线程调用A方法。
    */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockReentrantMain {

    public static void main(String[] args) {

        LockR1 lockR1 = new LockR1();
        new Thread(lockR1).start();
        new Thread(lockR1).start();

//        LockR2 lockR2 = new LockR2();
//        new Thread(lockR2).start();
//        new Thread(lockR2).start();
    }
}

/*
可重入锁举例一：
不同的线程分别调用这个两个方法
*/
class LockR1 implements Runnable {

    int num = 10;
    Lock lock = new ReentrantLock();

    @Override
    public void run() {

        add();
        inc();
    }

    void add() {
        if (lock.tryLock()) {
            try {
                num++;
                System.out.println(Thread.currentThread().getName() + " add : " + num);
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + "尝试获取锁失败");
        }
    }

    void inc() {
        if (lock.tryLock()) {
            try {
                num--;
                System.out.println(Thread.currentThread().getName() + " inc : " + num);
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + "尝试获取锁失败");
        }
    }
}

/*
可重入锁举例二：
同一个线程，A方法中调用B方法，这个线程调用A方法。
*/
class LockR2 implements Runnable {

    int num = 10;
    Lock lock = new ReentrantLock();

    @Override
    public void run() {

        add();
    }

    void add() {
//        if (lock.tryLock()) {
//            try {
//                num++;
//                System.out.println(Thread.currentThread().getName() + " add : " + num);
//                inc();
//            } finally {
//                lock.unlock();
//            }
//        } else {
//            System.out.println(Thread.currentThread().getName()+"尝试获取锁失败");
//        }


        lock.lock();
        try {
            num++;
            System.out.println(Thread.currentThread().getName() + " add : " + num);
            inc();
        } finally {
            lock.unlock();
        }

    }

    void inc() {
//        if (lock.tryLock()) {
//            try {
//                num--;
//                System.out.println(Thread.currentThread().getName() + " inc : " + num);
//            } finally {
//                lock.unlock();
//            }
//        } else {
//            System.out.println(Thread.currentThread().getName() + "尝试获取锁失败");
//        }

        lock.lock();
        try {
            num--;
            System.out.println(Thread.currentThread().getName() + " inc : " + num);
        } finally {
            lock.unlock();
        }
    }
}
