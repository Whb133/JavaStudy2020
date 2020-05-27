package threadPractice.ThreadSynchronized;

public class AddOne implements Runnable{
    static int flag = 0;
    @Override
    public void run() {
        add();
        decrease();
    }


    public synchronized void add(){
        flag++;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"  add()  "+flag);

    }
    public synchronized void decrease(){
        flag--;
        System.out.println(Thread.currentThread().getName()+"  decrease()  "+flag);
    }
    public static void main(String[] args){
        AddOne addone = new AddOne();
        Thread t1 = new Thread(addone,"t1");
        Thread t2 = new Thread(addone,"t2");
        Thread t3 = new Thread(addone,"t3");
        Thread t4 = new Thread(addone,"t4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
