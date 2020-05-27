package threadPractice.LockTypes.ReentAndNonReent.NonReetrant;

public class NonReentrantLock {


    //    Lock lock = new ReentrantLock();
    boolean isLocked = false;
    Thread thread = null;


    public void lock() {
        while (isLocked && thread != Thread.currentThread()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLocked = true;
        thread = Thread.currentThread();
    }

    public void unlock() {

        isLocked = false;
    }
}

