package threadPractice.ThreadSynchronized;

public class AlternatePrint {
    public static void main(String[] args) {

        SelfAdd sa = new SelfAdd();
        Thread t1 = new Thread(sa, "t1");
        Thread t2 = new Thread(sa, "t2");
        t1.start();
        t2.start();
    }
}

class SelfAdd implements Runnable {
    int num = 1;

//    public void run() {
//        while (true) {
//            synchronized (this) {
//                this.notify();
//                if (num <= 100) {
//                    System.out.println(Thread.currentThread().getName() + " " + num);
//                    num++;
//                } else {
//                    break;
//                }
//                try {
//                    this.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }


    @Override
    public void run(){
        add();
    }

    public synchronized void add(){
        while (true){
            this.notify();
            if (num <= 100){
                System.out.println(Thread.currentThread().getName() + " " + num);
                num++;
            }else {
                break;
            }
            try{
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
