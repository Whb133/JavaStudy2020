package threadPractice.LockTypes.ReentAndNonReent.NonReetrant;

public class NumChange implements Runnable {

    int num = 10;
//    NonReentrantLock lock = new NonReentrantLock();
    NonReentrantLock2 lock = new NonReentrantLock2();


    @Override
    public void run() {
        add();
    }

    void add() {

        try {
            lock.lock();
            num++;
            System.out.println(Thread.currentThread().getName() + " add : " + num);
            inc();
        } finally {
            lock.unlock();
        }
    }

    void inc() {

        try {
            lock.lock();
            num--;
            System.out.println(Thread.currentThread().getName() + " inc : " + num);
        } finally {
            lock.unlock();
        }
    }

}
class Main {
    public static void main(String[] args) {

        NumChange numChange = new NumChange();
        new Thread(numChange).start();
        new Thread(numChange).start();

//        new NumChange().add();
    }
}
