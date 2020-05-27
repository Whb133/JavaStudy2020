package threadPractice.ThreadSynchronized;

public class TicketSale implements Runnable {
    static int ticket_num = 200;
    static int thread_num = 4;
    int id;
    TicketSale(int id){
        this.id= id;
    }
    @Override
    public void run() {
        synchronized (TicketSale.class){
            while (true){
                while (ticket_num % thread_num !=this.id) {
                    if (ticket_num <= 0) {
                        break;
                    }
                    try {
                        TicketSale.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (ticket_num <= 0) {
                    break;
                }
                System.out.println(Thread.currentThread().getName()+"售卖票号"+ticket_num);
                ticket_num--;
                TicketSale.class.notifyAll();
            }
        }
    }

    public static void main(String[] args) {

        Thread t1 =new Thread(new TicketSale(0),"t1");
        Thread t2 =new Thread(new TicketSale(1),"t2");
        Thread t3 =new Thread(new TicketSale(2),"t3");
        Thread t4 =new Thread(new TicketSale(3),"t4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
