package threadPractice.LockTypes.LockAndSync;

public class SyncMain {
    public static void main(String[] args) {
        /*
        同步方法的总结：
        同步方法仍然需要锁（同步监视器），只是不需要显式声明。
        非静态同步方法：同步监视器是   this
        静态同步方法：同步监视器是   当前类本身(当前类.class)
         */

        //使用实现Runnable接口的代码块锁解决同步
//        ThreadImplCodeBlock threadImplCodeBlock = new ThreadImplCodeBlock();
//        new Thread(threadImplCodeBlock).start();
//        new Thread(threadImplCodeBlock).start();

        //使用实现Runnable接口的方法锁解决同步
//        ThreadImplMethod threadImplMethod = new ThreadImplMethod();
//        new Thread(threadImplMethod).start();
//        new Thread(threadImplMethod).start();

        //使用继承Thread类的代码块锁解决同步
//        new ThreadExteCodeBlock().start();
//        new ThreadExteCodeBlock().start();

        //使用继承Thread类的方法锁解决同步
        new ThreadExteMethod().start();
        new ThreadExteMethod().start();
    }

}

    /*
    实现Runnable接口创建线程，new Thread(Runnable target),每个参数target参数都是相同对象，
    不用给Runnable实现类成员变量定义为static，多个线程就可以共享。
     */

class ThreadImplCodeBlock implements Runnable {

    int num = 500;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {   //this  指当前对象，即ThreadImplCodeBlock实例化的对象threadImplCodeBlock
                if (num > 0) {
                    System.out.println(Thread.currentThread().getName() + "  :  " + num--);
                } else {
                    break;
                }
            }
        }
    }
}

class ThreadImplMethod implements Runnable {

    /*
    实现Runnable接口创建线程，new Thread(Runnable target),每个参数target参数都是相同对象，
    不用给Runnable实现类成员变量定义为static，多个线程就可以共享。
     */

    int num = 500;
    boolean flag = true;
    @Override
    public void run() {
        while (flag) {
            show();
        }
    }

    synchronized void show() {//synchronized  指调用当前方法的对象，即ThreadImplMethod实例化的对象
        if (num > 0) {
            System.out.println(Thread.currentThread().getName() + "  :  " + num--);
        }else {
            flag = false;
        }
    }
}

    /*
    继承Thread类创建线程，new Thread(),每个线程对象不一样，
    需要给类成员变量定义为static，多个线程对象才可以共享。
     */
class ThreadExteCodeBlock extends Thread {

    static int num = 500;

    @Override
    public void run() {
        while (true) {
            /*
            synchronized (this) {
            此处不能使用this，因为是使用继承Thread实现多线程，有多个Thread对象.
            给this加锁，相当于给每个独立对象加锁，无法实现同步，需要给整个类加锁，形成类锁（只存在于概念）
            因为java中类也是一个对象，即Class类，而ThreadExteCodeBlock.class即该类的一个对象。满足synchronized (Object obj)
             */
            synchronized (ThreadExteCodeBlock.class) {
                if (num > 0) {
                    System.out.println(Thread.currentThread().getName() + "  :  " + num--);
                } else {
                    break;
                }
            }
        }
    }
}

class ThreadExteMethod extends Thread {

    /*
    实现Runnable接口创建线程，new Thread(Runnable target),每个参数target参数都是相同对象，
    不用给Runnable实现类成员变量定义为static，多个线程就可以共享。
     */

    static int num = 500;
    static boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            show();
        }
    }

    static synchronized void show() {//synchronized  指调用当前方法的类，即ThreadExteMethod.class
        if (num > 0) {
            System.out.println(Thread.currentThread().getName() + "  :  " + num--);
        }else {
            flag = false;
        }
    }
}
