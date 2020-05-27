package threadPractice.LockTypes.LockAndSync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockMain {
    /*
    lock锁，jdk1.5新增
     */
    public static void main(String[] args) {
        /*ReentrantLock()两个构造方法
        有参，参数是boolean fair,是否是一个公平锁（谁先来谁先执行）
        无参，默认非公平锁
         */

        LockThreadImplCodeBlock lockThread = new LockThreadImplCodeBlock();
        new Thread(lockThread).start();
        new Thread(lockThread).start();
    }
}

class LockThreadImplCodeBlock implements Runnable {

    int num = 500;
    int count = 1;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            if (lock.tryLock()) {
                try {
                    if (num > 0) {
                        System.out.println(Thread.currentThread().getName() + "  :  " + num--);
                    } else {
                        break;
                    }
                } finally {
                    lock.unlock();
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }else {
                System.out.println(Thread.currentThread().getName()+"获取锁失败"+count++);
            }
        }
    }

}
