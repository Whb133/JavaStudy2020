package threadPractice.MultiThread;

public class AlternatelyThreadPrint {
    /*
    使用多线程交替输出打印1-100
     */

    public static final int ThreadNum = 10;

    public static void main(String[] args) {
        for (int i = 0; i < ThreadNum; i++) {
//            new Thread(new PrintThread(i)).start();
            new Thread(new PrintThread2(i)).start();
        }
    }
}

class PrintThread implements Runnable {

    int id;
    static int count = 1;

    PrintThread(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        synchronized (PrintThread.class) {
            while (true) {
                if (count > 100) {
                    break;
                } else if (count % AlternatelyThreadPrint.ThreadNum == id) {
                    System.out.println("Thread: " + id + " is printing " + count);
                    count++;
                } else {
                    try {
                        PrintThread.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                PrintThread.class.notifyAll();
            }
        }
    }
}


class PrintThread2 implements Runnable {

    int id;
    static int count = 1;

    PrintThread2(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        synchronized (PrintThread2.class) {
            while (true) {

                while (count % AlternatelyThreadPrint.ThreadNum != id) {
                    if (count > 100) {
                        break;
                    }
                    try {

                        //wait()必须再拥有锁时调用，且在某对象wait状态，会释放锁，sleep（）不会释放锁
                        PrintThread2.class.wait();

//                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (count > 100) {
                    break;
                }
                System.out.println("Thread: " + id + " is printing " + count);
                count++;
                PrintThread2.class.notifyAll();
            }
        }
    }
}
